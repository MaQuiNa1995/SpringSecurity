package maquina1995.spring.security.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class AbstractWebserviceLv2Controller<K, E> {

	@Autowired
	protected JpaRepository<E, K> repository;

	@PostMapping
	public ResponseEntity<E> create(@RequestBody E dto) {
		return ResponseEntity.ok(repository.save(dto));
	}

	@GetMapping({ "", "/{id}" })
	public ResponseEntity<List<E>> find(@RequestParam(required = false) K id) {

		List<E> dtos = (id == null) ? repository.findAll()
		        : Arrays.asList(repository.findById(id)
		                .orElseThrow(() -> new IllegalStateException("No existe ese id en Bd")));

		return ResponseEntity.ok(dtos);
	}

	@PatchMapping
	public ResponseEntity<E> update(@RequestBody E dto) {
		return ResponseEntity.ok(repository.save(dto));
	}

	@DeleteMapping
	public ResponseEntity<K> delete(@RequestParam K id) {
		repository.deleteById(id);
		return ResponseEntity.ok(id);
	}
}