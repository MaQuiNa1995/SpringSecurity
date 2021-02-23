package maquina1995.spring.security.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Personaje {

	@Id
	@GeneratedValue(generator = "sequencePersonaje",
	        strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequencePersonaje",
	        allocationSize = 1)
	private Long id;
	private String nombre;

}
