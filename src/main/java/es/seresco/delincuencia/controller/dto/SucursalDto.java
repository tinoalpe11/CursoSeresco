package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class SucursalDto {
	
	
	@JsonProperty("id")
	private Long id;

	@NotNull
	@Length(max=10)
	@JsonProperty("codigo")
	private String codigo;

	@NotNull
	@Length(max=50)
	@JsonProperty("direccion")
	private String direccion;

	@NotNull
	@Length(max=100)
	@JsonProperty("nombreDirector")
	private String nombreDirector;
	
	@NotNull
	@JsonProperty("idBanco")
	private Long idBanco;

	public SucursalDto(@NotNull String codigo, @NotNull String direccion, @NotNull String nombreDirector,
			@NotNull Long idBanco) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
		this.nombreDirector = nombreDirector;
		this.idBanco = idBanco;
	}
	
	


}
