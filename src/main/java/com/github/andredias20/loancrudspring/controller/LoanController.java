package com.github.andredias20.loancrudspring.controller;

import com.github.andredias20.loancrudspring.dto.loan.LoanGetDTO;
import com.github.andredias20.loancrudspring.dto.loan.LoanPostDTO;
import com.github.andredias20.loancrudspring.dto.loan.LoanPutDTO;
import com.github.andredias20.loancrudspring.entity.Loan;
import com.github.andredias20.loancrudspring.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService service;

    @GetMapping
    public List<Loan> GetLoans() {
        return service.GetAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Loan> GetLoanById(@PathVariable Long id){
        Loan loan = service.GetLoanById(id);
        if(loan == null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LoanGetDTO> insert(@RequestBody LoanPostDTO dto){
        var loan = service.create(dto);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LoanGetDTO> updateById(@PathVariable Long id, @RequestBody LoanPutDTO loan){
        var record = service.update(id, loan);
        if(record == null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(record, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean executed = service.delete(id);
        if(!executed) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
