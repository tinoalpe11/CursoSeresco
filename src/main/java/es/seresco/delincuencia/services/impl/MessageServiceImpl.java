package es.seresco.delincuencia.services.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.services.MessageSourceDelincuencia;

@Service
public class MessageServiceImpl implements MessageSourceDelincuencia {

	
	@Autowired
	private MessageSource messageSource;

	
	
	
	public String getValue(String key) {
		return messageSource.getMessage(key, null, new Locale("es"));
	}

	
	
	public String getValue(String key, Locale locale) {
		return messageSource.getMessage(key, null, locale);
	}

	
	
	public String getValueWithParams(String key, Locale locale, Object... params) {
		return messageSource.getMessage(key, params, locale);
	}
	
	

	

	
}
