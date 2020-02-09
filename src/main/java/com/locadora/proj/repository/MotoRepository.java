package com.locadora.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.proj.models.Cliente;
import com.locadora.proj.models.Moto;

public interface MotoRepository extends JpaRepository<Moto, String> {

	Moto findByCodigo(long codigo);

	Moto findOne(Long id);

}
