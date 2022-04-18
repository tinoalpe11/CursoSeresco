package es.seresco.delincuencia.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DelincuenteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6683150606668386601L;
	private Long id;
	private String nombre;
	private String identificador;
	//private List<String> armas;
	//private int idBanda;

}
