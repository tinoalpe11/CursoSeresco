package es.seresco.delincuencia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.model.TarjetaCredito;

@Repository
public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long>{
	
	List<TarjetaCredito> findByFechaCaducidadBetween(LocalDate fechaInicial, LocalDate fechaFinal);
	

}
