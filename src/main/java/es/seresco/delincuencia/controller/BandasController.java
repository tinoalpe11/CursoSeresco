package es.seresco.delincuencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.controller.dto.NewBandaDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.services.BandasService;
import es.seresco.delincuencia.services.DelicuentesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = {"Bandas"})
@RestController
@RequestMapping(path = "/api/banda")

public class BandasController {

	@Autowired
	private BandasService bandasService;

	@Autowired
	private DelicuentesService delincuentesService;

	
	
	@ApiOperation(value = "Obtiene una banda según el parámetro Id", notes="Para poner una descripción mucho más larga...")
	@GetMapping(path = "/{idBanda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BandaDto> getBanda(@PathVariable Long idBanda) {
		
		BandaDto banda = bandasService.getBanda(idBanda);
	
		if (banda != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	
	
	// añade una banda pasada mediante RequestBody
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BandaDto> createBanda(@Validated @RequestBody NewBandaDto newBandaDto) {

		BandaDto banda = bandasService.createBanda(newBandaDto);
		
		
		if (banda != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	
	
	// Actualiza una banda indicando el id como parte del path
	@PutMapping(path = "/{idBanda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BandaDto> updateBanda( @PathVariable Long idBanda, @Validated @RequestBody NewBandaDto updatedBanda) throws MiValidationException {

		BandaDto banda = bandasService.updateBanda(idBanda, updatedBanda);
		
		if (banda != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
		

//	// Actualiza una banda indicando el id como parte del path
//	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<BandaDto> actualizaBanda(@Validated @RequestBody BandaDto updatedBanda) {
//
//		//TODO: Buscar En la lista de bandas, la que coincide por id con la indicada en el body y actualizar los valores con los recibidos.
//		
//		log.info("Banda actualizada");
//
//		return null;
//	}
	
	
	
	// devuelve los delincuentes de una banda
	@GetMapping(path = "/{idBanda}/delincuentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DelincuenteDto>> getDelincuentesBanda(@PathVariable Long idBanda) {

		List<DelincuenteDto> delincEncontrados = delincuentesService.findDelincuentes();
				
		if (delincEncontrados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(delincEncontrados);
		}
	}

	
	
	// busca una banda filtrando por ciudad y el número de delincuentes
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BandaDto>> getBandas(@RequestParam(required = false) String ciudad,
													@RequestParam(required = false) Integer numMiembros) throws MiValidationException {

		
//		Utilidad util = new Utilidad();
//		util.miMetodo();
		
		List<BandaDto> bandasEncontradas = bandasService.findBandas();
		
		if(bandasEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(bandasEncontradas);
		}
	}

	
	
	@DeleteMapping(path = "/{idBanda}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteBanda(@PathVariable Long idBanda) {

		//TODO: Buscar en la lista de bandas la indicada y borrarla de la lista.
		
		//Ojo aqui. Retorna void (no retorno datos). Pero indico con una anotación el codigo http de la respuesta 204.
	}

}
