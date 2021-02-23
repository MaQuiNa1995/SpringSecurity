package maquina1995.spring.security.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

	@Id
	@GeneratedValue(generator = "sequenceRol",
	        strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequenceRol",
	        allocationSize = 1)
	private Long id;
	private String nombre;
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

}
