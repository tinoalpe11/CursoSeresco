package es.seresco.delincuencia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.SucursalDto;

@Service
public interface SucursalService {

	
	SucursalDto getSucursal(Long idSucursal);
	
	List<SucursalDto> findSucursales (); 
	
	List<SucursalDto> findSucursalesBanco (Long idBanco); 

	SucursalDto createSucursal(SucursalDto sucursalDto);
	
	SucursalDto deleteSucursal(Long idSucursal);
}
