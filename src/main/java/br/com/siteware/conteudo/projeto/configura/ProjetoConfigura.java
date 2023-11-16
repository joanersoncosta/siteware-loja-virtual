package br.com.siteware.conteudo.projeto.configura;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@RestController
public class ProjetoConfigura {

	private static final String LOCAL_DATE_TIME= "yyyy-MM-dd'T'HH:mm:ss'Z'";
	static final LocalDateTimeSerializer DATE_TIME_SELIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME)) ;
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		
		JavaTimeModule module = new JavaTimeModule();
		module.addSerializer(DATE_TIME_SELIALIZER);
		return new ObjectMapper().registerModules(module);
	}
}
