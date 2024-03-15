package com.github.andredias20.loancrudspring.dto.loan;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class LoanGetDTO {

    private Long id;
    private Date date;
    private String currency;
    private Double value;
    private Double conversion_tax;
    private Date loan_expire_date;

}
