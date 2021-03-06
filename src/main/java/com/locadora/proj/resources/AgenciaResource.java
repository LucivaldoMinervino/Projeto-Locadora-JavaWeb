package com.locadora.proj.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.locadora.proj.models.Agencia;
import com.locadora.proj.repository.AgenciaRepository;

@Controller
@RequestMapping("/agencias")

public class AgenciaResource {

	@Autowired
	private AgenciaRepository agencias;

	@PostMapping
	public Agencia adicionar(@Valid @RequestBody Agencia agencia) {
		return agencias.save(agencia);
	}

	@GetMapping
	public List<Agencia> listar() {
		return agencias.findAll();
	}

	// VERIFICAR PROB ID

	@GetMapping("/{id}")
	public ResponseEntity<Agencia> buscar(@PathVariable Long id) {
		Agencia agencia = agencias.findOne(id);

		if (agencia == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(agencia);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Agencia> atualizar(@PathVariable Long id, @Valid @RequestBody Agencia agencia) {

		Agencia existe = agencias.findOne(id);

		if (existe == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(agencia, existe, "id");
		existe = agencias.save(existe);
		return ResponseEntity.ok(existe);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		Agencia agencia = agencias.findOne(id);
		if (agencia == null) {
			return ResponseEntity.notFound().build();
		}

		agencias.delete(agencia);
		return ResponseEntity.noContent().build();
	}
}
