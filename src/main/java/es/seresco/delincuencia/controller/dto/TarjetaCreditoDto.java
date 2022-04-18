package es.seresco.delincuencia.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.seresco.delincuencia.model.Banco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TarjetaCreditoDto {

	@JsonProperty("Nombre")
	private String nombre;
	
	@JsonProperty("Apellido")
	private String apellido1;
	
	@JsonProperty("Num. Tarjeta")
	private String numeroTarjeta;
	
	@JsonProperty("Fecha cad.")	
	private LocalDate fechaCaducidad;
	
	private LocalDate fechaInicial;
	
	private LocalDate fechaFinal;
		
	
	@JsonProperty("Banco")
	private Banco banco;
}
