package com.github.andredias20.loancrudspring.repository;

import com.github.andredias20.loancrudspring.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
