package maquina1995.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import maquina1995.spring.security.domain.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

}
