package com.cafeteria.cafeteria.repository;

import com.cafeteria.cafeteria.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long>
{

}
