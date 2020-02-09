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

import com.locadora.proj.models.Cliente;
import com.locadora.proj.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")

public class ClienteResource {

	@Autowired
	private ClienteRepository clien;

	@PostMapping
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clien.save(cliente);
	}

	@GetMapping
	public List<Cliente> listar() {
		return clien.findAll();
	}

	@GetMapping("/id")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Cliente ct = clien.findOne(id);
		return ResponseEntity.ok(ct);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente existe = clien.findOne(id);

		if (existe == null) {
			return ResponseEntity.notFound().build();

		}

		BeanUtils.copyProperties(cliente, existe, "id");

		existe = clien.save(existe);

		return ResponseEntity.ok(existe);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		Cliente clientedeletarCliente = clien.findOne(id);

		if (clientedeletarCliente == null) {
			return ResponseEntity.notFound().build();
		}
		clien.delete(clientedeletarCliente);
		return ResponseEntity.noContent().build();
	}

}
