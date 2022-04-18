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

import es.seresco.delincuencia.controller.dto.SucursalDto;
import es.seresco.delincuencia.services.SucursalService;
import io.swagger.annotations.Api;

@Api(tags = {"Sucursales"})
@RestController
@RequestMapping(path="api/sucursal")
public class SucursalesController {

	@Autowired
	private SucursalService sucursalService;

	// Devuelve una sucursal por id
	@GetMapping(path = "/{idSucursal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucursalDto> getSucursal(@PathVariable Long idSucursal) {
		
		SucursalDto sucursal = sucursalService.getSucursal(idSucursal);
	
		if (sucursal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sucursal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	// Devuelve las sucursales de un banco
	@GetMapping(path = "/banco/{idBanco}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SucursalDto>> findSucursalesBanco(@PathVariable Long idBanco) {

		List<SucursalDto> listaSucursalesBanco = sucursalService.findSucursalesBanco(idBanco);
				
		if (listaSucursalesBanco.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaSucursalesBanco);
		}
	}
	
	// Devuelve todas las sucursales
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SucursalDto>> findSucursales() {

		List<SucursalDto> listaSucursales = sucursalService.findSucursales();
				
		if (listaSucursales.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaSucursales);
		}
	}
	
	// Crea una sucursal nueva
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucursalDto> createSucursal(@Validated @RequestBody SucursalDto sucursalDto) {

		SucursalDto sucursal = sucursalService.createSucursal(sucursalDto);
		
		
		if (sucursal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sucursal);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	// Borra una sucursal
	@DeleteMapping(path = "/{idSucursal}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public ResponseEntity<SucursalDto> deleteSucursal(@Validated @PathVariable Long idSucursal) {
		
		SucursalDto sucursal = sucursalService.deleteSucursal(idSucursal);
		
		
		if (sucursal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sucursal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	
}
