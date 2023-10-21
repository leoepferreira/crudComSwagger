package com.example.clienteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientsRepository clientsRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clientsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clientsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clientsRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clientsRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clientsRepository.deleteById(id);
    }
}
