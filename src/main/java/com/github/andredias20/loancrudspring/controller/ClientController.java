package com.github.andredias20.loancrudspring.controller;

import com.github.andredias20.loancrudspring.dto.client.ClientGetDTO;
import com.github.andredias20.loancrudspring.dto.client.ClientPostDTO;
import com.github.andredias20.loancrudspring.dto.client.ClientPutDTO;
import com.github.andredias20.loancrudspring.entity.Client;
import com.github.andredias20.loancrudspring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> GetClients() {
        return service.GetAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> GetClientById(@PathVariable Long id){
        Client client = service.GetClientById(id);
        if(client == null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientGetDTO> InsertClient(@RequestBody ClientPostDTO dto){
        var client = service.CreateClient(dto);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientGetDTO> UpdateClientById(@PathVariable Long id, @RequestBody ClientPutDTO client){
        var record = service.UpdateClient(id, client);
        if(record == null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(record, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> DeleteClient(@PathVariable Long id) {
        boolean executed = service.DeleteClient(id);
        if(!executed) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
