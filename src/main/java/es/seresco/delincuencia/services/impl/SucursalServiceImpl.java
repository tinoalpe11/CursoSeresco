package es.seresco.delincuencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;
import es.seresco.delincuencia.controller.dto.SucursalDto;
import es.seresco.delincuencia.model.Banco;
import es.seresco.delincuencia.model.Sucursal;
import es.seresco.delincuencia.repository.SucursalRepository;
import es.seresco.delincuencia.services.BancoService;
import es.seresco.delincuencia.services.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {
	
	@Autowired
	private SucursalRepository sucursalRepository;	
	
	@Autowired 
	private BancoService bancoService;
	
	// Devuelve todas las sucursales	
	public List<SucursalDto> findSucursales() {
		
		List<SucursalDto> sucursalesDto = new ArrayList<>();
		List<Sucursal> sucursales = sucursalRepository.findAll();
		
		if(sucursales.isEmpty() ) {
			return null;
		}
				
		for (Sucursal s : sucursales) {
			SucursalDto sucursalDto = new SucursalDto();
			
			sucursalDto.setId(s.getId());
			sucursalDto.setCodigo(s.getCodigo());
			sucursalDto.setDireccion(s.getDireccion());
			sucursalDto.setNombreDirector(s.getNombreDirector());
			sucursalDto.setIdBanco(s.getBanco().getId());
			
			sucursalesDto.add(sucursalDto);
			
	}
		return sucursalesDto;
	}

	public List<SucursalDto> findSucursalesBanco(Long idBanco) {
		
		List<SucursalDto> sucursalesDto = new ArrayList<>();
		List<Sucursal> sucursales = sucursalRepository.findAll();
		
		if(sucursales.isEmpty() ) {
			return null;
		}
				
		for (Sucursal s : sucursales) {
			SucursalDto sucursalDto = new SucursalDto();
			Long idBancoSucursal=s.getBanco().getId();
			if (idBancoSucursal==idBanco) {
							
			sucursalDto.setId(s.getId());
			sucursalDto.setCodigo(s.getCodigo());
			sucursalDto.setDireccion(s.getDireccion());
			sucursalDto.setNombreDirector(s.getNombreDirector());
			sucursalDto.setIdBanco(s.getBanco().getId());
			
			sucursalesDto.add(sucursalDto);
		}
	}
		return sucursalesDto;
	}
	// Devuelve una sucursal por Id
	public SucursalDto getSucursal(Long idSucursal) {
		SucursalDto sucursalDto = new SucursalDto();
		Sucursal sucursal = sucursalRepository.getById(idSucursal);
				
		if (sucursal != null) {
			sucursalDto.setId(sucursal.getId());
			sucursalDto.setCodigo(sucursal.getCodigo());
			sucursalDto.setDireccion(sucursal.getDireccion());
			sucursalDto.setNombreDirector(sucursal.getNombreDirector());
			sucursalDto.setIdBanco(sucursal.getBanco().getId());
			
			return sucursalDto;
					}
		return null;
			
	}
	
	// Crea una sucursal
	public SucursalDto createSucursal(SucursalDto sucursalDto) {
		
		Banco bancoNumsucursalModificado = new Banco();
		NewBancoDto updatedBanco = new NewBancoDto(); 
		Sucursal sucursal = new Sucursal();
		Long idBanco=sucursalDto.getIdBanco();
		
		sucursal.setCodigo(sucursalDto.getCodigo());
		sucursal.setDireccion(sucursalDto.getDireccion());
		sucursal.setNombreDirector(sucursalDto.getNombreDirector());
		sucursal.setBanco(buscarBanco(idBanco));
		
		sucursalRepository.saveAndFlush(sucursal);
		bancoNumsucursalModificado=buscarBanco(idBanco);
		
		updatedBanco.setId(idBanco);
		updatedBanco.setCodigo(bancoNumsucursalModificado.getCodigo());
		updatedBanco.setSede(bancoNumsucursalModificado.getSede());
		updatedBanco.setNumSucursales(bancoNumsucursalModificado.getNumSucursales()+1);
		
		bancoService.updateBanco(idBanco, updatedBanco); 
		return (sucursalDto);
	}

	// Borra una sucursal
	public SucursalDto deleteSucursal(Long idSucursal) {
		Banco bancoNumsucursalModificado = new Banco();
		NewBancoDto updatedBanco = new NewBancoDto(); 
		SucursalDto sucursalDto = new SucursalDto();
				
		Sucursal sucursal = sucursalRepository.getById(idSucursal);	
		
		if(sucursalRepository.existsById(idSucursal)) {
					
			sucursalDto.setId(sucursal.getId());
			sucursalDto.setCodigo(sucursal.getCodigo());
			sucursalDto.setDireccion(sucursal.getDireccion());
			sucursalDto.setNombreDirector(sucursal.getNombreDirector());
			sucursalDto.setIdBanco(sucursal.getBanco().getId());
			Long idBanco=sucursalDto.getIdBanco();
			
			sucursalRepository.deleteById(idSucursal);
			
			bancoNumsucursalModificado=buscarBanco(idBanco);
			
			updatedBanco.setId(idBanco);
			updatedBanco.setCodigo(bancoNumsucursalModificado.getCodigo());
			updatedBanco.setSede(bancoNumsucursalModificado.getSede());
			updatedBanco.setNumSucursales(bancoNumsucursalModificado.getNumSucursales()-1);
			
			bancoService.updateBanco(idBanco, updatedBanco); 
		
		return sucursalDto;
	}
		return null;
	}
		
	
	public Banco buscarBanco(Long idBanco) {
		
		Banco banco = new Banco();
		BancoDto bancoDto = bancoService.getBanco(idBanco);
		
		if(bancoDto != null) {
		
		banco.setId(bancoDto.getId());
		banco.setCodigo(bancoDto.getCodigo());
		banco.setSede(bancoDto.getSede());
		banco.setNumSucursales(bancoDto.getNumSucursales());
		
		return banco;
		}
		
		return null;	
		
		
	}

}
