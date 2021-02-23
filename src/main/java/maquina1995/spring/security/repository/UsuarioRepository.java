package maquina1995.spring.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import maquina1995.spring.security.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select user from Usuario user join fetch user.roles where user.userName = :nombreUsuario")
	Optional<Usuario> findUserName(String nombreUsuario);

}
