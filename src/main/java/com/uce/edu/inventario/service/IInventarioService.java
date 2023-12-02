package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Inventario;

public interface IInventarioService {

	public Inventario buscar(String codigo);

	public void guardar(Inventario inventario);

	public void actulizar(Inventario inventario);

	public void borrar(String codigo);
	
	public void registrar(String codigoBodega, String CodigoBarras, Integer stock);
}
