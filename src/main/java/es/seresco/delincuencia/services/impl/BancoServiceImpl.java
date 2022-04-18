package es.seresco.delincuencia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;
import es.seresco.delincuencia.model.Banco;
import es.seresco.delincuencia.repository.BancoRepository;
import es.seresco.delincuencia.services.BancoService;

@Service
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	private BancoRepository bancoRepository;
	
		
	public List<NewBancoDto> findBancos() {
		
		List<NewBancoDto> bancosDto = new ArrayList<>();
		List<Banco> bancos = bancoRepository.findAll();
		
		
		if(bancos.isEmpty() ) {
			return null;
		}
		
		
		for (Banco b : bancos) {
			NewBancoDto bancoDto = new NewBancoDto();
			bancoDto.setId(b.getId());
			bancoDto.setCodigo(b.getCodigo());
			bancoDto.setSede(b.getSede());
			bancoDto.setNumSucursales(b.getNumSucursales());	
			bancosDto.add(bancoDto);
			
	}
		return bancosDto;
	}



	
	public BancoDto getBanco(Long idBanco) {
		BancoDto bancoDto = new BancoDto();
		Banco banco = bancoRepository.getById(idBanco);
		
		
		if (banco != null) {
			bancoDto.setId(banco.getId());
			bancoDto.setCodigo(banco.getCodigo());
			bancoDto.setSede(banco.getSede());
			bancoDto.setNumSucursales(banco.getNumSucursales());
			
		}
		return bancoDto;
			
	}
	
	public BancoDto createBanco(BancoDto bancoDto) {
		
		Banco banco = new Banco();
		banco.setCodigo(bancoDto.getCodigo());
		banco.setSede(bancoDto.getSede());
		banco.setNumSucursales(bancoDto.getNumSucursales());
		
		bancoRepository.saveAndFlush(banco);
			
		return (bancoDto);
	}

	public BancoDto updateBanco(Long idBanco, NewBancoDto updatedBanco)  {
		
		BancoDto bancoDto = new BancoDto();
		Banco banco = bancoRepository.getById(idBanco);
		
				
		if (banco!=null) {
			
		//bandasRepository.delete(banda);
		
			banco.setCodigo(updatedBanco.getCodigo());
			banco.setSede(updatedBanco.getSede());
			banco.setNumSucursales(updatedBanco.getNumSucursales());
		
		bancoRepository.saveAndFlush(banco);
		
		bancoDto.setId(banco.getId());
		bancoDto.setCodigo(banco.getCodigo());
		bancoDto.setNumSucursales(banco.getNumSucursales());
		
		return bancoDto;
		
		}
		return null;
	}

	
	public BancoDto deleteBanco(Long idBanco) {
		BancoDto bancoDto = new BancoDto();
		Banco banco = bancoRepository.getById(idBanco);	
		
		if(bancoRepository.existsById(idBanco)) {
			
		
		bancoDto.setId(banco.getId());
		bancoDto.setCodigo(banco.getCodigo());
		bancoDto.setSede(banco.getSede());
		bancoDto.setNumSucursales(banco.getNumSucursales());
		
		bancoRepository.deleteById(idBanco);
		
		return bancoDto;
	}
		return null;
	}
	

}
