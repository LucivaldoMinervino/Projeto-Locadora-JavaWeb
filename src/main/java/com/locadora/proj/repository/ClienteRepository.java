package com.locadora.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.proj.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
	Cliente findByCodigo(long codigo);

	Cliente findOne(Long id);
}
