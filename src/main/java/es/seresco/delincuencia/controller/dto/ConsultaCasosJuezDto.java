package es.seresco.delincuencia.controller.dto;

import es.seresco.delincuencia.model.TipoCondena;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class ConsultaCasosJuezDto {
	
			
	private Long count;
	
	private TipoCondena tipoCondena;

	public ConsultaCasosJuezDto(Long count, TipoCondena tipoCondena) {
		super();
		this.count = count;
		this.tipoCondena = tipoCondena;
	}
	
		

}
