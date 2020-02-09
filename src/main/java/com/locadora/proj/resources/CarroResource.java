package com.locadora.proj.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.locadora.proj.models.Carro;
import com.locadora.proj.repository.CarroRepository;

@Controller
@RequestMapping("/carros")

public class CarroResource {

	@Autowired
	public CarroRepository carros;

	@PostMapping
	public Carro adicionar(@Valid @RequestBody Carro carro) {
		return carros.save(carro);
	}

	@GetMapping
	public List<Carro> listar() {
		return carros.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carro> buscar(@PathVariable Long id) {
		Carro car = carros.findOne(id);

		if (car == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(car);
	}

	@PutMapping("/{id}")

	public ResponseEntity<Carro> atualizar(@PathVariable Long id, @Valid @RequestBody Carro carro) {

		Carro existe = carros.findOne(id);

		if (existe == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(carro, existe, "id");
		existe = carros.save(existe);
		return ResponseEntity.ok(existe);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		Carro carrodeleta = carros.findByCodigo(id);
		if (carrodeleta == null) {
			return ResponseEntity.notFound().build();
		}

		carros.delete(carrodeleta);
		return ResponseEntity.noContent().build();
	}
}
