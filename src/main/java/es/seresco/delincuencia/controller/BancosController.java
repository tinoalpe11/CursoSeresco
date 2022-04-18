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

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;
import es.seresco.delincuencia.services.BancoService;
import io.swagger.annotations.Api;

@Api(tags= {"Bancos"})
@RestController
@RequestMapping(path="/api/banco")
public class BancosController {
	
	@Autowired
	BancoService bancoService;
	
	// Devuelve un banco por id
	
		@GetMapping(path = "/{idBanco}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<BancoDto> getBanco(@PathVariable Long idBanco) {
			
			BancoDto banco = bancoService.getBanco(idBanco);
			
			if (banco != null) {
				return ResponseEntity.status(HttpStatus.OK).body(banco);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
	// Devuelve la lista de bancos
		
		@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<NewBancoDto>> findBancos(){
						
			
			List<NewBancoDto> bancosDto = bancoService.findBancos();
			
			if (bancosDto.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.status(HttpStatus.OK).body(bancosDto);
			
		}
		
		// Añade un banco
		
		@PostMapping(path = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<BancoDto> createBanco(@Validated @RequestBody BancoDto bancoDto) {
	
			BancoDto banco = bancoService.createBanco(bancoDto);
			
			
			if (banco != null) {
				return ResponseEntity.status(HttpStatus.OK).body(banco);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		//Borra un banco
		@DeleteMapping(path = "/{idBanco}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.NO_CONTENT) 
		public ResponseEntity<BancoDto> deleteBanco(@Validated @PathVariable Long idBanco) {
			
			BancoDto banco = bancoService.deleteBanco(idBanco);
			
			
			if (banco != null) {
				return ResponseEntity.status(HttpStatus.OK).body(banco);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		

}
