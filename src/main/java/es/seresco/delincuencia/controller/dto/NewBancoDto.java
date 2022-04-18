package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewBancoDto {

	private Long id;
	
	@NotEmpty
	private String codigo;
	
	@NotEmpty
	private String sede;
	
	@NotEmpty
	private int numSucursales;
	
	
}
