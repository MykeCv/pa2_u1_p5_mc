package com.uce.edu.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Producto;
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.seleccionar(codigoBarras);
	}

	@Override
	public void guardar(Producto producto) {
		this.iProductoRepository.insertar(producto);
		
	}

	@Override
	public void actulizar(Producto producto) {
		this.iProductoRepository.actulizar(producto);
		
	}

	@Override
	public void borrar(String codigoBarras) {
		this.iProductoRepository.borrar(codigoBarras);
		
	}

}
