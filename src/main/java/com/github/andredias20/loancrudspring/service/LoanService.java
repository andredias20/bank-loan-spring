package com.github.andredias20.loancrudspring.service;

import com.github.andredias20.loancrudspring.dto.loan.LoanGetDTO;
import com.github.andredias20.loancrudspring.dto.loan.LoanPostDTO;
import com.github.andredias20.loancrudspring.dto.loan.LoanPutDTO;
import com.github.andredias20.loancrudspring.entity.Loan;
import com.github.andredias20.loancrudspring.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    @Autowired
    private LoanDtoService dtoService;

    public List<Loan> GetAll() {
        return repository.findAll();
    }

    public Loan GetLoanById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public LoanGetDTO create(LoanPostDTO dto) {
        Loan loan = dto.dtoToObject();
        Loan saved = repository.save(loan);
        return dtoService.objectToGetDto(saved);
    }

    public LoanGetDTO update(Long id, LoanPutDTO dto) {
        Loan search = GetLoanById(id);

        if(search == null) return null;

        search.setDate(dto.getDate());
        search.setCurrency(dto.getCurrency());
        search.setTotal_value(dto.getTotal_value());
        search.setConversion_tax(dto.getConversion_tax());
        search.setLoan_expire_date(dto.getLoan_expire_date());

        Loan updated = repository.save(search);
        return dtoService.objectToGetDto(updated);
    }


    public boolean delete(Long id) {
        Loan record = this.GetLoanById(id);
        if(record == null) return false;
        repository.deleteById(id);
        return true;
    }

}
