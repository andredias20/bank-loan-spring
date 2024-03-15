package com.github.andredias20.loancrudspring.dto.loan;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class LoanGetDTO {

    private Long id;
    private Date date;
    private String currency;
    private Double total_value;
    private Double conversion_tax;
    private Date loan_expire_date;

}
