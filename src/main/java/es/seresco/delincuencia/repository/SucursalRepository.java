package es.seresco.delincuencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository <Sucursal, Long>{
	
	@Query("select s from Sucursal s where s.banco.id = ?1")
	public List<Sucursal> sucursalPorBanco (Long idBanco);
		
		
	}
	


