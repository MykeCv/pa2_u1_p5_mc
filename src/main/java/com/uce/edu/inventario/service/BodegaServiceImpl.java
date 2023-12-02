package com.uce.edu.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
@Service
public class BodegaServiceImpl implements IBodegaService{

	@Autowired
	private IBodegaRepository bodegaRepository;
	
	@Override
	public Bodega buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.bodegaRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Bodega bodega) {
		this.bodegaRepository.insertar(bodega);
		
	}

	@Override
	public void actulizar(Bodega bodega) {
		this.bodegaRepository.actulizar(bodega);
		
	}

	@Override
	public void borrar(String codigo) {
		this.bodegaRepository.borrar(codigo);
		
	}

}
