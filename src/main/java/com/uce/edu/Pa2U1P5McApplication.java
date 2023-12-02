package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5McApplication implements CommandLineRunner {

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IBodegaService bodegaService;
	
	@Autowired
	private IInventarioService iInventarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Producto p1 = new Producto();
		p1.setCodigoBarras("123654");
		p1.setNombre("HP 15 Laptop");
		p1.setStock(0);
		
		this.iProductoService.guardar(p1);
		
		Producto p2 = new Producto();
		p2.setCodigoBarras("456321");
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		
		this.iProductoService.guardar(p2);
		
		Bodega b1 = new Bodega();
		b1.setNombre("Mundo laptop");
		b1.setDireccion("Quito");
		b1.setCodigo("1254");
		
		this.bodegaService.guardar(b1);
		
		this.iInventarioService.registrar("1254","123654" , 50);
		this.iInventarioService.registrar("1254", "456321", 100);
		this.iInventarioService.registrar("1254", "123654", 20);
		
		
	}
	
}
