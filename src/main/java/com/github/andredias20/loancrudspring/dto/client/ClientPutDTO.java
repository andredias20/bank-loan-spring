package com.github.andredias20.loancrudspring.dto.client;

import com.github.andredias20.loancrudspring.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientPutDTO {

    private String name;
    private String phone_number;

    public Client dtoToObject(){
        return new Client(name, phone_number);
    }

}
