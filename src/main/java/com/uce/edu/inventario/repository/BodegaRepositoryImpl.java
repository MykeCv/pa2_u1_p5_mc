package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {

	private static List<Bodega> base = new ArrayList<Bodega>();
	@Override
	public Bodega seleccionar(String codigo) {
		for (Bodega bodega : base) {
			if (bodega.getCodigo()== codigo) {
				Bodega bodega1 = new Bodega();
				bodega1.setNombre(bodega1.getNombre());
				bodega1.setDireccion(bodega1.getDireccion());
				bodega1.setCapacidad(bodega1.getCapacidad());
				return bodega1;
			}
		}
		return null;
	}

	@Override
	public void insertar(Bodega bodega) {
		base.add(bodega);

	}
	@Override
	public void actulizar(Bodega bodega) {
		this.borrar(bodega.getCodigo());
		this.insertar(bodega);

	}
	
	public Bodega seleccionarEliminar(String numero) {
		for (Bodega bodega : base) {
			if (bodega.getCodigo().equals(numero)) {	
				return bodega;
			}
		}

		return null;
	}

	@Override
	public void borrar(String codigo) {
		Bodega bodega = this.seleccionarEliminar(codigo);
		base.remove(bodega);
	}

}
