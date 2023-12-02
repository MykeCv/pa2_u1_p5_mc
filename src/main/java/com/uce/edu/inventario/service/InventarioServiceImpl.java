package com.uce.edu.inventario.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.IInventarioRepository;
import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;

@Service
public class InventarioServiceImpl implements IInventarioService {

	@Autowired
	private IInventarioRepository iInventarioRepository;
	@Autowired
	private IProductoRepository iProductoRepository;
	@Autowired
	private IBodegaRepository bodegaRepository;

	@Override
	public Inventario buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.iInventarioRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Inventario inventario) {
		this.iInventarioRepository.insertar(inventario);

	}

	@Override
	public void actulizar(Inventario inventario) {
		this.iInventarioRepository.actulizar(inventario);

	}

	@Override
	public void borrar(String codigo) {
		this.iInventarioRepository.borrar(codigo);

	}

	@Override
	public void registrar(String codigoBodega, String CodigoBarras, Integer stock) {
		// TODO Auto-generated method stub
		Bodega bodega = this.bodegaRepository.seleccionar(codigoBodega);

		Producto producto = this.iProductoRepository.seleccionar(CodigoBarras);
		Integer stockActual = producto.getStock();
		Integer stockFinal = stockActual + stock;
		producto.setStock(stockFinal);
		this.iProductoRepository.actulizar(producto);

		Inventario inventario = new Inventario();
		inventario.setCodigo("147852");
		inventario.setFechaIngreso(LocalDateTime.now());
		inventario.setBodega(bodega);
		inventario.setProducto(producto);
		
		this.iInventarioRepository.insertar(inventario);
	}

}
