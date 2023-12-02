package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Producto;
@Repository
public class ProductoRepositoryImpl implements IProductoRepository {

	private static List<Producto> base = new ArrayList<Producto>();

	@Override
	public Producto seleccionar(String codigoBarras) {
		for (Producto producto : base) {
			if (producto.getNombre() == codigoBarras) {
				Producto producto1 = new Producto();
				producto1.setCodigoBarras(producto1.getCodigoBarras());
				producto1.setNombre(producto1.getNombre());
				producto1.setStock(producto1.getStock());
				return producto1;
			}
		}
		return null;
	}

	@Override
	public void insertar(Producto producto) {
		base.add(producto);
	}

	@Override
	public void actulizar(Producto producto) {
		this.borrar(producto.getCodigoBarras());
		this.insertar(producto);

	}

	public Producto seleccionarEliminar(String numero) {
		for (Producto producto : base) {
			if (producto.getCodigoBarras().equals(numero)) {
				return producto;
			}
		}

		return null;
	}

	@Override
	public void borrar(String codigoBarras) {
		Producto producto = this.seleccionarEliminar(codigoBarras);
		base.remove(producto);

	}

}
