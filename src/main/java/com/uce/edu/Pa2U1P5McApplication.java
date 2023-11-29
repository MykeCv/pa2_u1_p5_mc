package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5McApplication implements CommandLineRunner {

	//DI por constructor
	/*private ITransferenciaService iTransferenciaService;
	@Autowired

	public Pa2U1P5McApplication(ITransferenciaService iTransServi) {
		this.iTransferenciaService=iTransSer1vi;
	}*/
	
	//Inyeccion de dependencia por metodo
	/*@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}*/
	
	//DI por Atributo
		@Autowired
		private ITransferenciaService iTransferenciaService;


	@Autowired
	private ICuentaBancariaService bancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1724362106");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.bancariaService.guardar(ctaOrigen);

		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1724362114");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.bancariaService.guardar(ctaDestino);

		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));
	
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));
		this.iTransferenciaService.realizar("5678", "1234", new BigDecimal(10));
	
		//Construir un reporte del estado de cuenta de todas las transferencias
		System.out.println("Lista de reportes de las transacciones: ");
		int i =0;
		for(Transferencia trans:iTransferenciaService.reporte()) {
			i++;
			System.out.println(i+":"+trans);
		}
		CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		this.bancariaService.Depositar(BigDecimal.valueOf(100), "1234");
		
		CuentaBancaria ctaOrigen2 = this.bancariaService.buscar("1234");
		System.out.println(ctaOrigen2);
		
		CuentaBancaria ctaDestino1 = this.bancariaService.buscar("5678");
		System.out.println(ctaDestino1);
		
	}
	
}
