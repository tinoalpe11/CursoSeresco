package es.seresco.delincuencia.services.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


@Service("fbi")
@Order(1)
public class BandasServiceFBIImpl {
	
	private static final String BEAN_NAME = "FBI";

//	@Autowired
//	private BandasRepository bandasRepository;	
//	
//	@Autowired
//	private MessageSourceDelincuencia messageSource;

	
	
	
//	public BandaDto getBanda(Long idBanda) {
//		log.info("Usando bean {}, para obtener banda {}", BEAN_NAME, idBanda);
//		return bandasRepository.getBanda(idBanda);
//	}
//	
//
//	
//	public BandaDto create(NewBandaDto newBanda) {
//		log.info("Usando bean {}, para crear banda", BEAN_NAME);
//		return bandasRepository.create(newBanda);
//	}
//		
//
//	
//	public List<BandaDto> findBandas (String ciudad, Integer numMiembros) throws MiValidationException {
//		log.info("Usando bean {}, para obtener listado de bandas...", BEAN_NAME);
//		if (StringUtils.isNotBlank(ciudad) && "Oviedo".equalsIgnoreCase(ciudad.trim())) {
//			throw new MiValidationException("128", messageSource.getValue("key.prueba.mensajes"));
//		}
//		
//		return bandasRepository.findBandas(ciudad, numMiembros);
//	}
//
//
//	
//	public BandaDto updateBanda(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException {
//		log.info("Usando bean {}, para updatear banda {}...", BEAN_NAME, idBanda);
//		return bandasRepository.update(idBanda, updatedBanda);
//	}
//
//
//	
//	public BandaDto updateBanda(BandaDto updatedBanda) throws MiValidationException {
//		log.info("Usando bean {}, para updatear banda...", BEAN_NAME);
//		return bandasRepository.update(updatedBanda);
//	}
//
//
//	
//	public void deleteBanda(Long idBanda) throws MiValidationException{
//		log.info("Usando bean {}, para eliminar banda {}...", BEAN_NAME, idBanda);
//		bandasRepository.deleteBanda(idBanda);
//	}
	
}
