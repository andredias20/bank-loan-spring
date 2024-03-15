package com.github.andredias20.loancrudspring.dto.loan;

import com.github.andredias20.loancrudspring.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class LoanPutDTO {

    private Date date;
    private String currency;
    private Double total_value;
    private Double conversion_tax;
    private Date loan_expire_date;

    public Loan dtoToObject(){
        return new Loan(
                this.date,
                this.currency,
                this.total_value,
                this.conversion_tax,
                this.loan_expire_date
        );
    }

}
