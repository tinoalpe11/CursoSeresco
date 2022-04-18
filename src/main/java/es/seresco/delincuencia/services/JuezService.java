package es.seresco.delincuencia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.JuezCasosDto;
import es.seresco.delincuencia.controller.dto.JuezDto;

@Service
public interface JuezService {

	
	JuezDto getJuez(Long idJuez);
	
	JuezCasosDto getCasos(Long idJuez);

	List<JuezDto> findJueces();
	
	JuezDto createJuez(JuezDto idJuez);
	 	
	JuezDto deleteJuez(Long idJuez);
	
	JuezDto updateJuez(Long idJuez, JuezDto updatedJuez) ;
}
