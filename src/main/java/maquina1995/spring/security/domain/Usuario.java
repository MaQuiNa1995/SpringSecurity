package maquina1995.spring.security.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(generator = "sequenceUsuario",
	        strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequenceUsuario",
	        allocationSize = 1)
	private Long id;
	private String userName;
	private String password;

	@Singular(value = "rol")
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuariosTienenRoles",
	        joinColumns = @JoinColumn(name = "FK_USUARIO"),
	        inverseJoinColumns = @JoinColumn(name = "FK_ROL"))
	private List<Rol> roles;

}
