package maquina1995.spring.security.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maquina1995.spring.security.domain.Personaje;

@RestController
@RequestMapping("/personaje")
public class PersonajeControllerImpl extends AbstractWebserviceLv2Controller<Long, Personaje> {

	@Override
	@PreAuthorize("hasRole('CREATE')")
	public ResponseEntity<Personaje> create(Personaje dto) {
		return super.create(dto);
	}

	@Override
	@PreAuthorize("hasRole('READ')")
	public ResponseEntity<List<Personaje>> find(Long id) {
		return super.find(id);
	}

	@Override
	@PreAuthorize("hasRole('UPDATE')")
	public ResponseEntity<Personaje> update(Personaje dto) {
		return super.update(dto);
	}

	@Override
	@PreAuthorize("hasRole('DELETE')")
	public ResponseEntity<Long> delete(Long id) {
		return super.delete(id);
	}

}
