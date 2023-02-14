package io.github.rioferraz1.clientes.model.repository;

import io.github.rioferraz1.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
