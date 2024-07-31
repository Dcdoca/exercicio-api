package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import classe.cliente;
import classe.contabancaria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface contabancariarepository extends JpaRepository<contabancaria, Long> {
    contabancaria findByNumeroConta(String numeroConta);
}