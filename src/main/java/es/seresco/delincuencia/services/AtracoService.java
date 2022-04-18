package es.seresco.delincuencia.services;

import java.util.List;

import es.seresco.delincuencia.controller.dto.AtracoDto;

public interface AtracoService {
	
	AtracoDto getAtraco(Long idAtraco);
	
	List<AtracoDto> findAtracos (); 
	
	List<Integer> casosPorJuez(Long idJuez);

	AtracoDto createAtraco(AtracoDto atracoDto);
	
	AtracoDto deleteAtraco(Long idAtraco);
}
