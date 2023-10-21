package com.example.clienteapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Cliente, Long> {
}
