package br.com.siteware.conteudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SitewareLojaVirtualApplication {

	@GetMapping
	public String getHomeTeste() {
		return "Siteware Loja Virtual - API Home";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SitewareLojaVirtualApplication.class, args);
	}

}
