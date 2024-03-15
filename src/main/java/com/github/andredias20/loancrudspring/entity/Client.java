package com.github.andredias20.loancrudspring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @SequenceGenerator(name = "client_generator", sequenceName = "client_seq", allocationSize = 1)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 25)
    private String phone_number;

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phone_number = phoneNumber;
    }
}
