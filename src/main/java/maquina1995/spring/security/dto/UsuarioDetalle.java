package maquina1995.spring.security.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import maquina1995.spring.security.domain.Rol;
import maquina1995.spring.security.domain.Usuario;

@Getter
public class UsuarioDetalle implements UserDetails {

	private final String username;
	private final String password;
	private final List<GrantedAuthority> authorities;

	public UsuarioDetalle(Usuario usuario) {
		this.username = usuario.getUserName();
		this.password = usuario.getPassword();

		this.authorities = usuario.getRoles()
		        .stream()
		        .map(Rol::getNombre)
		        .map(SimpleGrantedAuthority::new)
		        .collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
