package es.seresco.delincuencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.JuezCasosDto;
import es.seresco.delincuencia.controller.dto.JuezDto;
import es.seresco.delincuencia.model.Juez;
import es.seresco.delincuencia.repository.JuezRepository;
import es.seresco.delincuencia.services.AtracoService;
import es.seresco.delincuencia.services.JuezService;

@Service
public class JuezServiceImpl implements JuezService {

	@Autowired
	private JuezRepository juezRepository;
	
	@Autowired 
	private AtracoService atracoService;
	
	public List<JuezDto> findJueces() {
		
		List<JuezDto> juecesDto = new ArrayList<>();
		List<Juez> jueces = juezRepository.findAll();
				
		if(jueces.isEmpty() ) {
			return null;
		}
				
		for (Juez j : jueces) {
			JuezDto juezDto = new JuezDto();
			juezDto.setId(j.getId());
			juezDto.setCodigo(j.getCodigo());
			juezDto.setNombre(j.getNombre());
			
			juecesDto.add(juezDto);
			
	}
		return juecesDto;
	}
	
	public JuezDto getJuez(Long idJuez) {
		JuezDto juezDto = new JuezDto();
		Juez juez = juezRepository.getById(idJuez);
				
		if (juez != null) {
			juezDto.setId(juez.getId());
			juezDto.setCodigo(juez.getCodigo());
			juezDto.setNombre(juez.getNombre());
						
		}
		return juezDto;
			
	}
	
	public JuezCasosDto getCasos(Long idJuez)  {
		
		JuezCasosDto juezCasosDto = new JuezCasosDto();
		
		Juez juez = juezRepository.getById(idJuez);
					
		List<Integer> casos = atracoService.casosPorJuez(idJuez);
							
		if (casos.size() > 0) {
			
			Integer[] resultado = new Integer[3];
			int indice=0;
			for(Integer c :casos) {
			if (c == null) { c = 0;}	
			
			resultado[indice] = c;
			indice++;
		}
			
			juezCasosDto.setIdJuez(juez.getId());
			juezCasosDto.setCodigo(juez.getCodigo());
			juezCasosDto.setNombre(juez.getNombre());
			juezCasosDto.setCondenasGraves(resultado[0]);
			juezCasosDto.setCondenasLeves(resultado[1]);
			juezCasosDto.setCondenasMuyGraves(resultado[2]);
			juezCasosDto.setCasosTotales(resultado[0]+resultado[1]+resultado[2]);
			
		}
		return juezCasosDto;
	}
		
	public JuezDto createJuez(JuezDto juezDto) {
		
		Juez juez = new Juez();
		juez.setCodigo(juezDto.getCodigo());
		juez.setNombre(juezDto.getNombre());
		
		juezRepository.saveAndFlush(juez);
		
		juezDto.setId(juez.getId());
		juezDto.setCodigo(juez.getCodigo());
		juezDto.setNombre(juez.getNombre());
		
		return (juezDto);
	}

	public JuezDto updateJuez(Long idJuez, JuezDto updatedJuez)  {
		
		JuezDto juezDto = new JuezDto();
		Juez juez = juezRepository.getById(idJuez);
						
		if (juez!=null) {
			
		juez.setCodigo(updatedJuez.getCodigo());
		juez.setNombre(updatedJuez.getNombre());
					
		juezRepository.saveAndFlush(juez);
		
		juezDto.setId(juez.getId());
		juezDto.setCodigo(juez.getCodigo());
		juezDto.setNombre(juez.getNombre());
		
		return juezDto;
		
		}
		return null;
	}

	
	public JuezDto deleteJuez(Long idJuez) {
		JuezDto juezDto = new JuezDto();
		Juez juez = juezRepository.getById(idJuez);	
		
		if(juezRepository.existsById(idJuez)) {
					
		juezDto.setId(juez.getId());
		juezDto.setCodigo(juez.getCodigo());
		juezDto.setNombre(juez.getNombre());
		
		juezRepository.deleteById(idJuez);
		
		return juezDto;
	}
		return null;
	}
	
	
}
