package com.locadora.proj.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.proj.models.Moto;
import com.locadora.proj.repository.MotoRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/motos")

public class MotoResource {

	@Autowired

	private MotoRepository mot;

	@PostMapping
	public Moto adicionar(@Valid @RequestBody Moto m) {
		return mot.save(m);
	}

	@GetMapping
	public List<Moto> listar() {
		return mot.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Moto> buscar(@PathVariable Long id) {
		Moto mt = mot.findOne(id);
		return ResponseEntity.ok(mt);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Moto> atualizar(@PathVariable Long id, @Valid @RequestBody Moto m) {
		Moto existe = mot.findOne(id);

		if (existe == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(m, existe, "id");

		existe = mot.save(existe);

		return ResponseEntity.ok(existe);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		Moto motoDeleta = mot.findOne(id);

		if (motoDeleta == null) {
			return ResponseEntity.notFound().build();
		}

		mot.delete(motoDeleta);
		return ResponseEntity.noContent().build();

	}
}
