package es.seresco.delincuencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.model.Delincuente;
import es.seresco.delincuencia.repository.DelincuentesRepository;
import es.seresco.delincuencia.services.DelicuentesService;


@Service
public class DelincuentesServiceImpl implements DelicuentesService {

	@Autowired
	private DelincuentesRepository delincuentesRepository;
		
	public List<DelincuenteDto> findDelincuentes() {
		
		List<DelincuenteDto> delincuentesDto = new ArrayList<>();
		List<Delincuente> delincuentes = delincuentesRepository.findAll();
	
		
		if(delincuentes.isEmpty()) {
			return null;
		}
				
		for (Delincuente d : delincuentes) {
			
			DelincuenteDto delincuenteDto = new DelincuenteDto();
			delincuenteDto.setId(d.getId());
			delincuenteDto.setNombre(d.getNombre());
			delincuenteDto.setIdentificador(d.getIdentificador());
			delincuentesDto.add(delincuenteDto);
		
	}
		return delincuentesDto;
	}


	public DelincuenteDto getDelicuente(Long idDelincuente) {
		DelincuenteDto delincuenteDto = new DelincuenteDto();
		Delincuente delincuente = delincuentesRepository.getById(idDelincuente);
		
		
		if (delincuente != null) {
			delincuenteDto.setId(delincuente.getId());
			delincuenteDto.setIdentificador(delincuente.getIdentificador());
			delincuenteDto.setNombre(delincuente.getNombre());
			
		}
		return delincuenteDto;
		
	
	}


//
//	@Override
//	public DelincuenteDto createDelincuente(NewDelincuenteDto newDelincuente) {
//		
//		return delincuentesRepository.createDelincuente(newDelincuente);
//	}
//
//
//
//	@Override
//	public void deleteDeincuente(Long idDelincuente) {
//		
//		delincuentesRepository.deleteDeincuente(idDelincuente);
//	}
//	
}
