package es.seresco.delincuencia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.TarjetaCreditoDto;
import es.seresco.delincuencia.services.TarjetaCreditoService;
import io.swagger.annotations.Api;

@Api(tags= {"Tarjetas"})
@RestController
@RequestMapping(path="/api/tarjeta")
public class TarjetasCreditoController {
	
	@Autowired
	TarjetaCreditoService tarjetaCreditoService;
	
	@GetMapping(path = "/caducidad", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<TarjetaCreditoDto>> findByFechaCaducidadBetween(LocalDate fechaInicial, LocalDate fechaFinal) {

		List<TarjetaCreditoDto> tarjetasCaducan = tarjetaCreditoService.findByFechaCaducidadBetween(fechaInicial,fechaFinal);
		
		
		if (tarjetasCaducan.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(tarjetasCaducan);
	}

}
