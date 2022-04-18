package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JuezCasosDto {

//	@ToString.Exclude
//	private Long id;
	
	@JsonProperty("Juez id")
	private Long idJuez;
	
	@JsonProperty("codigo")
	@NotNull
	@Length(max=10)
	private String codigo;
	
	@JsonProperty("nombre")
	@NotNull
	@Length(max=50)
	private String nombre;
	
	@JsonProperty("casos totales")
	private Integer casosTotales;
	
	@JsonProperty("condenas leves")
	private Integer condenasLeves;
	
	@JsonProperty("condenas graves")
	private Integer condenasGraves;
	
	@JsonProperty("condenas muy graves")
	private Integer condenasMuyGraves;
	
		
}
