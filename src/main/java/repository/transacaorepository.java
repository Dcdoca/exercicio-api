package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import classe.contabancaria;
import classe.transacao;

public interface transacaorepository extends JpaRepository<transacao, Long> {
    List<transacao> findByContaOrigemOrContaDestino(contabancaria contaOrigem, contabancaria contaDestino);
}
