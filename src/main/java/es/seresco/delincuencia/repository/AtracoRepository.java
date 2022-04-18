package es.seresco.delincuencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.model.Atraco;

@Repository
public interface AtracoRepository extends JpaRepository <Atraco, Long> {
	
@Query("SELECT COUNT(a.juez.id) as count  FROM Atraco a where a.juez.id = ?1 GROUP BY a.tipoCondena ORDER BY a.tipoCondena")
public List<Integer> casosPorJuez(Long idJuez);

}
