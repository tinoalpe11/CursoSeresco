package es.seresco.delincuencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.seresco.delincuencia.model.Delincuente;

public interface DelincuentesRepository extends JpaRepository<Delincuente, Long> {

	
//	public DelincuenteDto getDelincuente(long idDelincuente);
//	
//	public List<DelincuenteDto> findDelincuentes();
//	
//	public DelincuenteDto createDelincuente(NewDelincuenteDto newDelincuente);
//	
//	public void deleteDeincuente(Long idDelincuente);
}
