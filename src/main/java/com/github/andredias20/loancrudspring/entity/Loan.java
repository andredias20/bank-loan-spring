package com.github.andredias20.loancrudspring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "loan")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_generator")
    @SequenceGenerator(name = "loan_generator", sequenceName = "loan_seq", allocationSize = 1)
    @JsonProperty("_id")
    private Long id;

    private Date date;
    @Column(length = 3)
    private String currency;
    private Double value;
    private Double conversion_tax;
    private Date loan_expire_date;

    public Loan(Date date, String currency, Double value, Double conversion_tax, Date loan_expire_date) {
        this.date = date;
        this.currency = currency;
        this.value = value;
        this.conversion_tax = conversion_tax;
        this.loan_expire_date = loan_expire_date;
    }
}
