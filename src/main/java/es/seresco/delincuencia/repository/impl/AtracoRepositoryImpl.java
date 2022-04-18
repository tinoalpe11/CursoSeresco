package es.seresco.delincuencia.repository.impl;

import org.springframework.stereotype.Repository;

@Repository
public class AtracoRepositoryImpl  {
	
//	private static List<AtracoDto> atracos;
//	
//	
//	static {
//		// creamos listas
//		atracos = new ArrayList<>();
//		
//		
//		LocalDate fecha;
//		TipoCondena tipoCondena;
//		
//
//		// creamos y añadimos atracos
//		
//		fecha = LocalDate.of(2020, Month.MAY, 23) ;
//		tipoCondena= TipoCondena.GRAVE;
//		AtracoDto atracoGordo = new AtracoDto(1L, fecha, tipoCondena, 5L);
//		atracos.add(atracoGordo);
//		
//		
//		fecha = LocalDate.of(2019, Month.APRIL, 15) ;
//		tipoCondena= TipoCondena.MUY_GRAVE;
//		AtracoDto atracoGrave = new AtracoDto(2L, fecha, tipoCondena, 3L);
//		atracos.add(atracoGrave);
//
//		
//		fecha = LocalDate.of(2021, Month.DECEMBER, 30) ;
//		tipoCondena= TipoCondena.LEVE;
//		AtracoDto atracoFallido = new AtracoDto(3L, fecha, tipoCondena, 7L);
//		atracos.add(atracoFallido);
//		
//		
//		fecha =LocalDate.of(2018, Month.FEBRUARY, 12) ;
//		tipoCondena= TipoCondena.GRAVE;
//		AtracoDto atracoMillones = new AtracoDto(4L, fecha, tipoCondena, 8L);
//		atracos.add(atracoMillones);
//	}
//
//	
//	public AtracoDto getAtraco(long id) {
//		for (AtracoDto atraco : atracos) {
//			if (atraco.getId().equals(id)) {
//				return atraco;
//			}
//		}
//		return null;
//	}
//
//		public List<AtracoDto> findAtracos (){
//		
//		List<AtracoDto> atracosPerpetrados = new ArrayList<>();
//
//		for (AtracoDto atraco : atracos) {
//			
//				atracosPerpetrados.add(atraco);
//			}
//		return atracosPerpetrados;
//		}
//
//				
//public AtracoDto createAtraco(NewAtracoDto newAtraco) {
//
//	AtracoDto atraco = new AtracoDto();
//	atraco.setFecha(newAtraco.getFecha());
//	atraco.setTipocondena(newAtraco.getTipocondena());
//	atraco.setIdSucursal(newAtraco.getIdSucursal());
//	
//	
//	atracos.add(atraco);
//	return atraco;
//}
//
//public void deleteAtraco(Long idAtraco) {
//	AtracoDto atraco = getAtraco(idAtraco);
//	if (atraco==null)
//		
//	atracos.remove(atraco);		
//}
//	
//	
}


