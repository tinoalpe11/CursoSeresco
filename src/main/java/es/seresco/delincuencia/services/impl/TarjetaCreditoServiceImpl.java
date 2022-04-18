package es.seresco.delincuencia.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.TarjetaCreditoDto;
import es.seresco.delincuencia.model.TarjetaCredito;
import es.seresco.delincuencia.repository.TarjetaCreditoRepository;
import es.seresco.delincuencia.services.TarjetaCreditoService;

@Service
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService {
	
	@Autowired
	TarjetaCreditoRepository tarjetaCreditoRepository;
	
	
	public List<TarjetaCreditoDto> findByFechaCaducidadBetween(LocalDate fechaInicial, LocalDate fechaFinal) {
		
		TarjetaCreditoDto tarjetaCreditoDto = new TarjetaCreditoDto();
		
		List<TarjetaCreditoDto> tarjetasCreditoCaducan = new ArrayList<>();
		
		List<TarjetaCredito> tarjetasCaducan = tarjetaCreditoRepository.findByFechaCaducidadBetween(fechaInicial, fechaFinal);
		
		if (tarjetasCaducan != null) {
			
			for (TarjetaCredito tar : tarjetasCaducan) {
			
			tarjetaCreditoDto.setNombre(tar.getNombre());
			tarjetaCreditoDto.setApellido1(tar.getApellido1());
			tarjetaCreditoDto.setBanco(tar.getBanco());
			tarjetaCreditoDto.setNumeroTarjeta(tar.getNumeroTarjeta());
			tarjetaCreditoDto.setFechaCaducidad(tar.getFechaCaducidad());
			tarjetaCreditoDto.setFechaInicial(fechaInicial);
			tarjetaCreditoDto.setFechaFinal(fechaFinal);
			
			tarjetasCreditoCaducan.add(tarjetaCreditoDto);
			
			return tarjetasCreditoCaducan;
			
			
			}
		}
		return tarjetasCreditoCaducan;
	}

}
