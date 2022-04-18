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
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.JuezCasosDto;
import es.seresco.delincuencia.controller.dto.JuezDto;
import es.seresco.delincuencia.services.JuezService;
import io.swagger.annotations.Api;

@Api(tags= {"Jueces"})
@RestController
@RequestMapping(path="/api/juez")
public class JuecesController {

	@Autowired
	JuezService juezService;
	
	// Devuelve un juez por id
	
		@GetMapping(path = "/{idJuez}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<JuezDto> getJuez(@PathVariable Long idJuez) {
			
			JuezDto juez = juezService.getJuez(idJuez);
			
			if (juez != null) {
				return ResponseEntity.status(HttpStatus.OK).body(juez);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	// Devuelve la lista de jueces
		
		@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<JuezDto>> findJueces(){
						
			
			List<JuezDto> juecesDto = juezService.findJueces();
			
			if (juecesDto.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.status(HttpStatus.OK).body(juecesDto);
			
		}
		
		// Devuelve los casos de un juez agrupados por tipo de condena
		
			@GetMapping(path = "/casos/{idJuez}", produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<JuezCasosDto> getCasos(@PathVariable Long idJuez) {
				
				JuezCasosDto juezCasos = juezService.getCasos(idJuez);
				
				if (juezCasos != null) {
					return ResponseEntity.status(HttpStatus.OK).body(juezCasos);
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				
			}
			
		
		// Añade un juez
		
		@PostMapping(path = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<JuezDto> createJuez(@Validated @RequestBody JuezDto juezDto) {
	
			JuezDto juez = juezService.createJuez(juezDto);
			
			
			if (juez != null) {
				return ResponseEntity.status(HttpStatus.OK).body(juez);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		//Borra un juez
		@DeleteMapping(path = "/{idJuez}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<JuezDto> deleteJuez(@Validated @PathVariable Long idJuez) {
			
			JuezDto juez = juezService.deleteJuez(idJuez);
			
			
			if (juez != null) {
				return ResponseEntity.status(HttpStatus.OK).body(juez);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		

	
}
