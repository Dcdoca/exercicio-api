package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import classe.cliente;
import classe.contabancaria;
import repository.clienterepository;
import repository.contabancariarepository;

import java.util.List;

@Service
public class contabancariaservice {
    @Autowired
    private contabancariarepository contaBancariaRepository;
    @Autowired
    private clienterepository clienteRepository;

    public contabancaria criarConta(Long clienteId, contabancaria contaBancaria) {
        cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente != null) {
            contaBancaria.setCliente(cliente);
            return contaBancariaRepository.save(contaBancaria);
        }
        return null;
    }

    public List<contabancaria> buscarTodasContas() {
        return contaBancariaRepository.findAll();
    }

    public contabancaria buscarContaPorNumero(String numeroConta) {
        return contaBancariaRepository.findByNumeroConta(numeroConta);
    }

    public contabancaria atualizarConta(Long id, contabancaria contaAtualizada) {
        contabancaria conta = contaBancariaRepository.findById(id).orElse(null);
        if (conta != null) {
            conta.setNumeroConta(contaAtualizada.getNumeroConta());
            conta.setSaldo(contaAtualizada.getSaldo());
            return contaBancariaRepository.save(conta);
        }
        return null;
    }

    public void deletarConta(Long id) {
        contaBancariaRepository.deleteById(id);
    }
}
