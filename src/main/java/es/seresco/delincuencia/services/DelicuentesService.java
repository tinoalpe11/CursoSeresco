package es.seresco.delincuencia.services;

import java.util.List;

import es.seresco.delincuencia.controller.dto.DelincuenteDto;

public interface DelicuentesService {

	DelincuenteDto getDelicuente(Long idDelincuente);

	List<DelincuenteDto> findDelincuentes();
	 
//	DelincuenteDto createDelincuente(NewDelincuenteDto newDelincuente);
//	
//	void deleteDeincuente(Long idDelincuente);
//	
}


