package es.seresco.delincuencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.model.BandaOrganizada;

@Repository
public interface BandasRepository extends JpaRepository <BandaOrganizada, Long>{
//
//	public BandaDto getBanda(long id);
//	
//	public BandaDto create(NewBandaDto newBanda);
//	
//	public List<BandaDto> findBandas (String ciudad, Integer numMiembros);
//
//	public BandaDto update(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException;
//
//	public BandaDto update(BandaDto updatedBanda) throws MiValidationException;
//
//	public void deleteBanda(Long idBanda) throws MiValidationException;
	
}
