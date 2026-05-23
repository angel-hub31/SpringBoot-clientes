package com.krakedev.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.krakedev" )

@EnableJpaRepositories(basePackages="com.krakedev")

@EntityScan(basePackages ="com.krakedev")

public class ClientesApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
