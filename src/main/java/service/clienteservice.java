package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import classe.cliente;
import repository.clienterepository;

import java.util.List;

@Service
public class clienteservice {
    @Autowired
    private clienterepository clienteRepository;

    public cliente criarCliente(cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public cliente atualizarCliente(Long id, cliente clienteAtualizado) {
        cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
