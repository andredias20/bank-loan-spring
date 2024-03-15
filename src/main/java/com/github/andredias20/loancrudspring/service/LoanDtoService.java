package com.github.andredias20.loancrudspring.service;

import com.github.andredias20.loancrudspring.dto.client.ClientGetDTO;
import com.github.andredias20.loancrudspring.dto.loan.LoanGetDTO;
import com.github.andredias20.loancrudspring.entity.Client;
import com.github.andredias20.loancrudspring.entity.Loan;
import org.springframework.stereotype.Service;

@Service
public class LoanDtoService {
    public LoanGetDTO objectToGetDto(Loan loan) {
        //TODO: Verify a way to use something like Reflection
        return new LoanGetDTO(
                loan.getId(),
                loan.getDate(),
                loan.getCurrency(),
                loan.getValue(),
                loan.getConversion_tax(),
                loan.getLoan_expire_date()
        );
    }
}
