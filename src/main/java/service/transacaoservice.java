package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import classe.contabancaria;
import classe.transacao;
import repository.contabancariarepository;
import repository.transacaorepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class transacaoservice {
    @Autowired
    private transacaorepository transacaoRepository;
    @Autowired
    private contabancariarepository contaBancariaRepository;

    public transacao transferir(Long contaOrigemId, Long contaDestinoId, Double valor) {
        contabancaria contaOrigem = contaBancariaRepository.findById(contaOrigemId).orElse(null);
        contabancaria contaDestino = contaBancariaRepository.findById(contaDestinoId).orElse(null);

        if (contaOrigem != null && contaDestino != null && contaOrigem.getSaldo() >= valor) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            contaBancariaRepository.save(contaOrigem);
            contaBancariaRepository.save(contaDestino);

            transacao transacao = new transacao();
            transacao.setContaOrigem(contaOrigem);
            transacao.setContaDestino(contaDestino);
            transacao.setValor(valor);
            transacao.setDataHora(LocalDateTime.now());

            return transacaoRepository.save(transacao);
        }
        return null;
    }

    public List<transacao> buscarTransacoes(Long contaId) {
        contabancaria conta = contaBancariaRepository.findById(contaId).orElse(null);
        if (conta != null) {
            return transacaoRepository.findByContaOrigemOrContaDestino(conta, conta);
        }
        return null;
    }
}