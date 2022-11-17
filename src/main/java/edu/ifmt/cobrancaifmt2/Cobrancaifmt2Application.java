package edu.ifmt.cobrancaifmt2;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class Cobrancaifmt2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cobrancaifmt2Application.class, args);
	}
	
	@Bean
	public FixedLocaleResolver localeResolver () {
		
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
