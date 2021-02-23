package maquina1995.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import maquina1995.spring.security.domain.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

}
