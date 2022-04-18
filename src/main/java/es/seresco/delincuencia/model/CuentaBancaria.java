package es.seresco.delincuencia.model;

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
@Table(name="CUENTA_BANCARIA")
public class CuentaBancaria extends ProductoBancario {
	
	
	
	private static final long serialVersionUID = -3492154487322119617L;

	@Column(name="NUMERO_CUENTA", nullable=false, length=30)
	private String numeroCuenta;
	
	@Column(name="SWIFT", nullable=false)
	private int swift;
	

}
