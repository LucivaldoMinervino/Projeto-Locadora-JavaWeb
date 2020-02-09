package com.locadora.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.proj.models.Agencia;
import com.locadora.proj.models.Cliente;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

	Agencia findByCodigo(long codigo);

	Agencia findOne(Long id);
}
