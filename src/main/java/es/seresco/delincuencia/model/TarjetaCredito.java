package es.seresco.delincuencia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper=true)

@Entity
@Table(name="TARJETA_CREDITO")

public class TarjetaCredito extends ProductoBancario {

	
	private static final long serialVersionUID = 4789971826634909201L;

	@Column(name="NUMERO_TARJETA", nullable=false, length=30)
	private String numeroTarjeta;
	
	@Column(name="FECHA_CADUCIDAD", nullable=true)
	private LocalDate fechaCaducidad;
	
}
