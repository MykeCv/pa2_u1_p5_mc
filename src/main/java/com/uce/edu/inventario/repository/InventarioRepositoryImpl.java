package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Inventario;
@Repository
public class InventarioRepositoryImpl implements IInventarioRepository {

	private static List<Inventario> base = new ArrayList<Inventario>();
	@Override
	public Inventario seleccionar(String codigo) {
		for (Inventario inventario : base) {
			if (inventario.getCodigo()== codigo) {
				Inventario inventario1 = new Inventario();
				inventario1.setBodega(inventario1.getBodega());
				inventario1.setCodigo(inventario1.getCodigo());
				inventario1.setFechaIngreso(inventario1.getFechaIngreso());
				inventario1.setProducto(inventario1.getProducto());
				return inventario1;
			}
		}
		return null;
	}

	@Override
	public void insertar(Inventario inventario) {
		base.add(inventario);

	}

	@Override
	public void actulizar(Inventario inventario) {
		this.borrar(inventario.getCodigo());
		this.insertar(inventario);


	}
	public Inventario seleccionarEliminar(String numero) {
		for (Inventario inventario : base) {
			if (inventario.getCodigo().equals(numero)) {	
				return inventario;
			}
		}

		return null;
	}

	@Override
	public void borrar(String codigo) {
		Inventario inventario = this.seleccionarEliminar(codigo);
		base.remove(inventario);

	}

}
