package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Producto;

public interface IProductoService {

	public Producto buscar(String codigoBarras);

	public void guardar(Producto producto);

	public void actulizar(Producto producto);

	public void borrar(String codigoBarras);
}
