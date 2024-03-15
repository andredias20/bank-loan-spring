package com.github.andredias20.loancrudspring.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientGetDTO {

    private Long id;
    private String name;
    private String phone_number;

}
