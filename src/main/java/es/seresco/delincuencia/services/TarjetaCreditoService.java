package es.seresco.delincuencia.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.TarjetaCreditoDto;

@Service
public interface TarjetaCreditoService {

	public List<TarjetaCreditoDto> findByFechaCaducidadBetween(LocalDate fechaInicial, LocalDate fechaFinal);
	
	
}
