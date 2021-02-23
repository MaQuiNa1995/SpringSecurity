package maquina1995.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import maquina1995.spring.security.domain.Personaje;
import maquina1995.spring.security.domain.Rol;
import maquina1995.spring.security.domain.Usuario;
import maquina1995.spring.security.repository.PersonajeRepository;
import maquina1995.spring.security.repository.UsuarioRepository;

@SpringBootApplication
public class Main implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Main.class);
	}

	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private PersonajeRepository personajeRepository;

	@Override
	@Transactional
	public void run(String... args) {

		Rol readRol = this.crearRol("READ");

		Usuario admin = Usuario.builder()
		        .userName("admin")
		        .password("admin")
		        .rol(this.crearRol("CREATE"))
		        .rol(readRol)
		        .rol(this.crearRol("UPDATE"))
		        .rol(this.crearRol("DELETE"))
		        .build();

		Usuario invitado = Usuario.builder()
		        .userName("invitado")
		        .password("invitado")
		        .rol(readRol)
		        .build();

		userRepository.save(admin);
		userRepository.save(invitado);

		Personaje personaje = Personaje.builder()
		        .nombre("Erza Scarlet")
		        .build();

		personajeRepository.save(personaje);

	}

	/**
	 * @return
	 */
	private Rol crearRol(String nombre) {
		return Rol.builder()
		        .nombre(nombre)
		        .build();
	}

}
