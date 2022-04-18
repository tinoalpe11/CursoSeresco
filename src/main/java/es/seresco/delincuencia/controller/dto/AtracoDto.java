package es.seresco.delincuencia.controller.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.seresco.delincuencia.model.TipoCondena;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtracoDto {

	@NotNull
	@JsonProperty("id")
	private Long id;
	
	@NotNull
	@JsonProperty("fecha")
	private Date fecha;
	
	@NotNull
	@JsonProperty("tipocondena")
	private TipoCondena tipoCondena;
	
	@NotNull
	@JsonProperty("idSucursal")
	private Long idSucursal;
	
	@NotNull
	@JsonProperty("idDelincuente")
	private Long idDelincuente;
	
	@NotNull
	@JsonProperty("idJuez")
	private Long idJuez;
	
		
}
