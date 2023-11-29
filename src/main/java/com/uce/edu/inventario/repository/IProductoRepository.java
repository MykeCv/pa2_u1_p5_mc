package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Producto;

public interface IProductoRepository {

	public Producto seleccionar(String codigoBarras);

	public void insertar(Producto producto);

	public void actulizar(Producto producto);

	public void borrar(String codigoBarras);
}
