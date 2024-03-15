package com.github.andredias20.loancrudspring.service;

import com.github.andredias20.loancrudspring.dto.client.ClientGetDTO;
import com.github.andredias20.loancrudspring.entity.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientDtoService {
    public ClientGetDTO objectToGetDto(Client client) {
        //TODO: Verify a way to use something like Reflection
        return new ClientGetDTO(client.getId(), client.getName(), client.getPhone_number());
    }
}
