package es.seresco.delincuencia.repository.impl;

import org.springframework.stereotype.Repository;

@Repository("BandasRespository")

public class BandasRepositoryImpl {



//	public BandaDto create(NewBandaDto newBanda) {
//
//		BandaDto banda = new BandaDto();
//		banda.setAlias(newBanda.getAlias());
//		banda.setCiudad(newBanda.getCiudad());
//		banda.setNombre(newBanda.getNombre());
//		banda.setNumMiembros(newBanda.getNumMiembros());
//
//		long idBanda = 0;
//		if (!bandas.isEmpty()) {
//			idBanda = bandas.get(bandas.size() - 1).getId().longValue() + 1;
//		}
//		banda.setId(Long.valueOf(idBanda));
//
//		bandas.add(banda);
//		return banda;
//	}
//	
//	
//	
//	public List<BandaDto> findBandas (String ciudad, Integer numMiembros){
//		
//		List<BandaDto> bandasEncontradas = new ArrayList<>();
//
//		for (BandaDto banda : bandas) {
//			if (StringUtils.isNotBlank(ciudad) || numMiembros != null) {
//				if (banda.getCiudad().equals(ciudad) && banda.getNumMiembros().equals(numMiembros)) {
//					bandasEncontradas.add(banda);
//				}
//			} else {
//				bandasEncontradas.add(banda);
//			}
//		}
//
//		return bandasEncontradas;
//	}
//	
//	
//
//	
//	public BandaDto update(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException{
//		BandaDto banda = getBanda(idBanda);
//		if (banda==null)
//			return null;
//		bandas.remove(banda);
//		banda.setAlias(updatedBanda.getAlias());
//		banda.setCiudad(updatedBanda.getCiudad());
//		banda.setNombre(updatedBanda.getNombre());
//		banda.setNumMiembros(updatedBanda.getNumMiembros());
//		bandas.add(banda);
//		return banda;
//	}
//
//	
//	
//	
//	public BandaDto update(BandaDto updatedBanda) throws MiValidationException {
//		BandaDto banda = getBanda(updatedBanda.getId());
//		bandas.remove(banda);
//		bandas.add(updatedBanda);
//		return updatedBanda;
//	}
//
//	
//	
//	
//	public void deleteBanda(Long idBanda) throws MiValidationException {
//		BandaDto banda = getBanda(idBanda);
//		if (banda==null)
//			throw new MiValidationException("201", "Banda no encontrada");
//		bandas.remove(banda);		
//	}
	
}
