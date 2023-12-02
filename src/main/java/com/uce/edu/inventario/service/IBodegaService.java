package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Bodega;

public interface IBodegaService {

	public Bodega buscar(String codigo);

	public void guardar(Bodega bodega);

	public void actulizar(Bodega bodega);

	public void borrar(String codigo);
}
