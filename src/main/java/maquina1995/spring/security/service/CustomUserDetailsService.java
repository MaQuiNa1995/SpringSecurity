package maquina1995.spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import maquina1995.spring.security.domain.Usuario;
import maquina1995.spring.security.dto.UsuarioDetalle;
import maquina1995.spring.security.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findUserName(userName);

		if (!user.isPresent()) {
			throw new UsernameNotFoundException("No hay un usuario con ese nombre: " + userName);
		}

		return user.map(UsuarioDetalle::new)
		        .get();
	}
}