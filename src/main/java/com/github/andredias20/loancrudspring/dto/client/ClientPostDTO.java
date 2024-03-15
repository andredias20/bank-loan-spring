package com.github.andredias20.loancrudspring.dto.client;

import com.github.andredias20.loancrudspring.entity.Client;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientPostDTO {

    @NotNull(message = "Name may not be Null")
    @NotEmpty(message = "Name may not be Empty")
    private String name;

    @NotNull(message = "Phone Number may not be Null")
    @NotEmpty(message = "Phone Number may not be Empty")
    private String phone_number;

    public Client dtoToObject(){
        return new Client(name, phone_number);
    }
}
