package com.github.andredias20.loancrudspring.service;

import com.github.andredias20.loancrudspring.dto.client.ClientGetDTO;
import com.github.andredias20.loancrudspring.dto.client.ClientPostDTO;
import com.github.andredias20.loancrudspring.dto.client.ClientPutDTO;
import com.github.andredias20.loancrudspring.entity.Client;
import com.github.andredias20.loancrudspring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientDtoService dtoService;

    public List<Client> GetAll() {
        return repository.findAll();
    }

    public Client GetClientById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ClientGetDTO CreateClient(ClientPostDTO dto) {
        Client client = dto.dtoToObject();
        Client saved = repository.save(client);
        return dtoService.objectToGetDto(saved);
    }

    public ClientGetDTO UpdateClient(Long id, ClientPutDTO dto) {
        Client search = GetClientById(id);

        if(search == null) return null;

        search.setName(dto.getName());
        search.setPhone_number(dto.getPhone_number());

        Client updated = repository.save(search);
        return dtoService.objectToGetDto(updated);
    }


    public boolean DeleteClient(Long id) {
        Client record = this.GetClientById(id);
        if(record == null) return false;
        repository.deleteById(id);
        return true;
    }
}
