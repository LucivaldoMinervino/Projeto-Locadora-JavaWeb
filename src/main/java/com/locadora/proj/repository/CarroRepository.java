package com.locadora.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.proj.models.Carro;
import com.locadora.proj.models.Cliente;

public interface CarroRepository extends JpaRepository<Carro, String> {

	Carro findByCodigo(long codigo);

	Carro findOne(Long id);

}
