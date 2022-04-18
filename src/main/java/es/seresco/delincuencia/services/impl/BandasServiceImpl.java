package es.seresco.delincuencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.NewBandaDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.model.BandaOrganizada;
import es.seresco.delincuencia.repository.BandasRepository;
import es.seresco.delincuencia.services.BandasService;
import es.seresco.delincuencia.services.MessageSourceDelincuencia;
import lombok.extern.slf4j.Slf4j;

//@Transactional
@Service
//@Scope("prototype")
//@Order(100)
@Slf4j
public class BandasServiceImpl implements BandasService {
	
	private static final String BEAN_NAME = "Original";

	@Autowired
	private BandasRepository bandasRepository;	
	
	@Autowired
	private MessageSourceDelincuencia messageSource;

	@Value("${victor.ws.url}")
	private String urlServicioVictor;
	
	@Value("${victor.ws.user}")
	private String userServicioVictor;
	
	@Value("${victor.ws.pass}")
	private String passServicioVictor;
	
	
	@Autowired
	private Environment environment;
	
	
	public List<BandaDto> findBandas() {
		//AtracoDto atracoDto = new AtracoDto();
		List<BandaDto> bandasDto = new ArrayList<>();
		List<BandaOrganizada> bandas = bandasRepository.findAll();
		
		
		if(bandas.isEmpty() ) {
			return null;
		}
		for (BandaOrganizada b : bandas) {
			BandaDto bandaDto = new BandaDto();
			bandaDto.setId(b.getId());
			bandaDto.setCodigo(b.getCodigo());
			bandaDto.setNumMiembros(b.getNumMiembros());
			bandasDto.add(bandaDto);
			
	}
		return bandasDto;
	}
	
	
	public BandaDto getBanda(Long idBanda) {
		log.info("Usando bean {}, para obtener banda {}", BEAN_NAME, idBanda);
		BandaDto bandaDto = new BandaDto();
		BandaOrganizada banda = bandasRepository.getById(idBanda);
		
		
		if (banda != null) {
			bandaDto.setId(banda.getId());
			bandaDto.setCodigo(banda.getCodigo());
			bandaDto.setNumMiembros(banda.getNumMiembros());
			
					}
		return bandaDto;
			
	}
		
	
	
public BandaDto createBanda(NewBandaDto newBandaDto) {
		BandaDto bandaDto = new BandaDto();
		BandaOrganizada banda = new BandaOrganizada();
		
		banda.setCodigo(newBandaDto.getCodigo());
		banda.setNumMiembros(newBandaDto.getNumMiembros());
		
		bandasRepository.saveAndFlush(banda);
		
		bandaDto.setId(banda.getId());
		bandaDto.setCodigo(banda.getCodigo());	
		bandaDto.setNumMiembros(banda.getNumMiembros());
		return (bandaDto);
	}

public BandaDto deleteBanda(Long idBanda) {
	BandaDto bandaDto = new BandaDto();
	BandaOrganizada banda = bandasRepository.getById(idBanda);	
	
	if(bandasRepository.existsById(idBanda)) {
		
	
		bandaDto.setId(banda.getId());
		bandaDto.setCodigo(banda.getCodigo());
		bandaDto.setNumMiembros(banda.getNumMiembros());
		
		bandasRepository.deleteById(idBanda);
	
		return bandaDto;
}
	return null;
}


//	@Override
//	public List<BandaDto> findBandas (String ciudad, Integer numMiembros) throws MiValidationException {
//		log.info("Usando bean {}, para obtener listado de bandas...", BEAN_NAME);
//		
//		//Suponemos que invocamos a Victor Servicio externo:
//		log.info("Simulación de invocación a servicio externo '{}' con usuario '{}' y password '{}'",
//															environment.getProperty("victor.ws.url"),
//															environment.getProperty("victor.ws.user"),
//															environment.getProperty("victor.ws.pass"));
//		
//		log.info("Simulación de invocación a servicio otro externo '{}' con usuario '{}' y password '{}'",
//															environment.getProperty("victor.otro.url"),
//															environment.getProperty("victor.otro.user"),
//															environment.getProperty("victor.otro.pass"));
//
//		
//		log.info("Simulación de invocación a servicio externo '{}' con usuario '{}' y password '{}'",
//															urlServicioVictor,
//															userServicioVictor,
//															passServicioVictor);
//		
//		
//		if (StringUtils.isNotBlank(ciudad) && "Oviedo".equalsIgnoreCase(ciudad.trim())) {
//			throw new MiValidationException("128", messageSource.getValue("key.prueba.mensajes"));
//		}
//		
//		return bandasRepository.findBandas(ciudad, numMiembros);
//	}
//
//
//	@Override
	public BandaDto updateBanda(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException {
		log.info("Usando bean {}, para updatear banda {}...", BEAN_NAME, idBanda);
		BandaDto bandaDto = new BandaDto();
		BandaOrganizada banda = bandasRepository.getById(idBanda);
		
				
		if (banda!=null) {
			
		//bandasRepository.delete(banda);
		
		banda.setCodigo(updatedBanda.getCodigo());
		banda.setNumMiembros(updatedBanda.getNumMiembros());
		
		bandasRepository.saveAndFlush(banda);
		
		bandaDto.setId(banda.getId());
		bandaDto.setCodigo(banda.getCodigo());
		bandaDto.setNumMiembros(banda.getNumMiembros());
		
		return bandaDto;
		
		}
		
		return null;
		
	}
	}
//
//
//	@Override
//	public BandaDto updateBanda(BandaDto updatedBanda) throws MiValidationException {
//		log.info("Usando bean {}, para updatear banda...", BEAN_NAME);
//		return bandasRepository.update(updatedBanda);
//	}
//
//
//	@Override
//	public void deleteBanda(Long idBanda) throws MiValidationException{
//		log.info("Usando bean {}, para eliminar banda {}...", BEAN_NAME, idBanda);
//		bandasRepository.deleteBanda(idBanda);
//	}
//	

