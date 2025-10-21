package com.cafeteria.cafeteria.controller;

import com.cafeteria.cafeteria.model.Clientes;
import com.cafeteria.cafeteria.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController
{
    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping
    public List<Clientes> getAll()
    {
        return clientesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Clientes getById(@PathVariable Long id)
    {
        return clientesRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Clientes create(@RequestBody Clientes clientes)
    {
        return clientesRepository.save(clientes);
    }

    @PutMapping("/{id}")
    public Clientes update(@PathVariable Long id, @RequestBody Clientes clientes)
    {
        clientes.setId_clientes(id);
        return clientesRepository.save(clientes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        clientesRepository.deleteById(id);
    }

}
