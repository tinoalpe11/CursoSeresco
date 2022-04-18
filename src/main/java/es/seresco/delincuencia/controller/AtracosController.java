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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.AtracoDto;
import es.seresco.delincuencia.services.AtracoService;
import io.swagger.annotations.Api;

@Api(tags = {"Atracos"})
@RestController
@RequestMapping(path="api/atraco")
public class AtracosController {
	
	
	@Autowired
	private AtracoService atracoService;

	@GetMapping(path = "/{idAtraco}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AtracoDto> getAtraco(@PathVariable Long idAtraco) {
		
		AtracoDto atraco = atracoService.getAtraco(idAtraco);
	
		if (atraco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(atraco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AtracoDto>> findAtracos() {

		List<AtracoDto> listaAtracos = atracoService.findAtracos();
				
		if (listaAtracos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaAtracos);
		}
	}
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AtracoDto> createAtraco( @RequestBody AtracoDto atracoDto) {

		AtracoDto atraco = atracoService.createAtraco(atracoDto);
		
		
		if (atraco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(atraco);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@DeleteMapping(path = "/{idAtraco}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public ResponseEntity<AtracoDto> deleteAtraco(@Validated @PathVariable Long idAtraco) {
		
		AtracoDto atraco = atracoService.deleteAtraco(idAtraco);
		
		
		if (atraco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(atraco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
}
