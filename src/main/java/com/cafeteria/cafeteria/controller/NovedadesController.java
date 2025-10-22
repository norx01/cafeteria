package com.cafeteria.cafeteria.controller;


import com.cafeteria.cafeteria.model.Clientes;
import com.cafeteria.cafeteria.model.Novedades;
import com.cafeteria.cafeteria.repository.ClientesRepository;
import com.cafeteria.cafeteria.repository.NovedadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/novedades")
public class NovedadesController
{
    @Autowired
    private NovedadesRepository novedadesRepository;

    @GetMapping
    public List<Novedades> getAll()
    {
        return novedadesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Novedades getById(@PathVariable Long id)
    {
        return novedadesRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Novedades create(@RequestBody Novedades novedades)
    {
        return novedadesRepository.save(novedades);
    }

    @PutMapping("/{id}")
    public Novedades update(@PathVariable Long id, @RequestBody Novedades novedades)
    {
        novedades.setId_novedades(id);
        return novedadesRepository.save(novedades);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        novedadesRepository.deleteById(id);
    }
}
