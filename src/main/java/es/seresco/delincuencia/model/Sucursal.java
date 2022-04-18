package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "SUCURSAL")
public class Sucursal implements Serializable {
	
	private static final long serialVersionUID = -4347117274148071411L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.PRIVATE)
	private Long id;

	@Column(name = "CODIGO", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "DIRECCION", nullable = false, length = 50)
	private String direccion;

	@Column(name = "NOMBRE_DIRECTOR", nullable = false, length = 100)
	private String nombreDirector;


	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "ID_BANCO")
	private Banco banco;

		
	public Sucursal(String codigo, String direccion, String nombreDirector) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
		this.nombreDirector = nombreDirector;
	}

	}
