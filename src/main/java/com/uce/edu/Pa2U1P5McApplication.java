package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P5McApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5McApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");
		System.out.println("Soy Michael Cevallos");
		System.out.println("Cambio en la misma rama");
		System.out.println("Cambio en una nueva rama taller 3");
		
	}

}
