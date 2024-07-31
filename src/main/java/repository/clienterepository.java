package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import classe.cliente;

public interface clienterepository extends JpaRepository<cliente, Long> {
}