package com.github.andredias20.loancrudspring.repository;

import com.github.andredias20.loancrudspring.entity.Client;
import com.github.andredias20.loancrudspring.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {}
