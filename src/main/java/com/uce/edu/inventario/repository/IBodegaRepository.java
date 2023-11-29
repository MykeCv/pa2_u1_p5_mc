package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

public interface IBodegaRepository {

	public Bodega seleccionar(String codigo);

	public void insertar(Bodega bodega);

	public void actulizar(Bodega bodega);

	public void borrar(String codigo);

}
