package io.github.rioferraz1.clientes.model.repository;

import io.github.rioferraz1.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {
}
