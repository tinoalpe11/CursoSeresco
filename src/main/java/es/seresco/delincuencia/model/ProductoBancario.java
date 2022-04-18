package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name="PRODUCTO_BANCARIO")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ProductoBancario implements Serializable {
	
	private static final long serialVersionUID = -3086972679583854579L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ToString.Exclude
	@Column
	private Long Id;
	
	@Column(name="NOMBRE", nullable=false, length=30)
	private String nombre;
	
	@Column(name="APELLIDO1", nullable=false, length=30)
	private String apellido1;
	
	@Column(name="APELLIDO2", nullable=false, length=30)
	private String apellido2;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="BANCO_ID")
	private Banco banco;
	
	

}
