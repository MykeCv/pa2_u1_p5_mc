package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Inventario;

public interface IInventarioRepository {

	public Inventario seleccionar(String codigo);

	public void insertar(Inventario inventario);

	public void actulizar(Inventario inventario);

	public void borrar(String codigo);
}
