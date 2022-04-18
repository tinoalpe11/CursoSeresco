package es.seresco.delincuencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.AtracoDto;
import es.seresco.delincuencia.model.Atraco;
import es.seresco.delincuencia.repository.AtracoRepository;
import es.seresco.delincuencia.services.AtracoService;

@Service
public class AtracoServiceImpl implements AtracoService {
	
	@Autowired
	private AtracoRepository atracoRepository;	
	
	// Devuelve todos los atracos	
	public List<AtracoDto> findAtracos() {
		//AtracoDto atracoDto = new AtracoDto();
		List<AtracoDto> atracosDto = new ArrayList<>();
		List<Atraco> atracos = atracoRepository.findAll();
		
		if(atracos.isEmpty() ) {
			return null;
		}
				
		for (Atraco a : atracos) {
			AtracoDto atracoDto = new AtracoDto();
			atracoDto.setId(a.getId());
			atracoDto.setFecha(a.getFecha());
			atracoDto.setIdDelincuente(a.getDelincuente().getId());
			atracoDto.setIdSucursal(a.getSucursal().getId());
			atracoDto.setIdJuez(a.getJuez().getId());
			atracoDto.setTipoCondena(a.getTipoCondena());
			atracosDto.add(atracoDto);
			
	}
		return atracosDto;
	}

	// Devuelve un atraco por Id
	public AtracoDto getAtraco(Long idAtraco) {
		AtracoDto atracoDto = new AtracoDto();
		Atraco atraco = atracoRepository.getById(idAtraco);
				
		if (atraco != null) {
			atracoDto.setId(atraco.getId());
			atracoDto.setFecha(atraco.getFecha());
			atracoDto.setIdDelincuente(atraco.getDelincuente().getId());
			atracoDto.setIdSucursal(atraco.getSucursal().getId());
			atracoDto.setIdJuez(atraco.getJuez().getId());
			
			return atracoDto;
					}
		return null;
			
	}
	
	// Devuelve las condenas por juez
	public List<Integer> casosPorJuez(Long idJuez) {
		
		
		List<Integer> casos = atracoRepository.casosPorJuez(idJuez);
		
		return casos;
	}
	
	
	// Crea un atraco
	public AtracoDto createAtraco(AtracoDto atracoDto) {
		
		//Atraco atraco = new Atraco();
		
//		atraco.setDelincuente().;)(atracoDto.getIdDelincuente());
//		atraco.setFecha(atracoDto.getFecha());
//		atraco.setJuez(atracoDto.getIdJuez());
//		atracoDto.setIdJuez(atraco.getJuez().getId());
//		atracoRepository.saveAndFlush(atraco);
			
		return (atracoDto);
	}

	// Borra un atraco
	public AtracoDto deleteAtraco(Long idAtraco) {
		AtracoDto atracoDto = new AtracoDto();
		Atraco atraco = atracoRepository.getById(idAtraco);	
		
		if(atracoRepository.existsById(idAtraco)) {
					
			atracoDto.setId(atraco.getId());
			atracoDto.setFecha(atraco.getFecha());
			atracoDto.setIdDelincuente(atraco.getDelincuente().getId());
			atracoDto.setIdSucursal(atraco.getSucursal().getId());
			atracoDto.setIdJuez(atraco.getJuez().getId());
		
		atracoRepository.deleteById(idAtraco);
		
		return atracoDto;
	}
		return null;
	}
	
}
