package com.pierre.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pierre.cursomc.services.DBService;
import com.pierre.cursomc.services.EmailService;
import com.pierre.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DBService dbService;
    //pegar a chave do prifil pra none ou create
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDataBase() throws ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instatiateTestDataBase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
