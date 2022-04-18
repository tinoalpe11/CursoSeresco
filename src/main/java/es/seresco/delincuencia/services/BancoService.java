package es.seresco.delincuencia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;

@Service
public interface BancoService {

	BancoDto getBanco(Long idBanco);

	List<NewBancoDto> findBancos();
	
	BancoDto createBanco(BancoDto bancoDto);
	 	
	BancoDto deleteBanco(Long idBanco);
	
	BancoDto updateBanco(Long idBanco, NewBancoDto updatedBanco) ;
	
}
