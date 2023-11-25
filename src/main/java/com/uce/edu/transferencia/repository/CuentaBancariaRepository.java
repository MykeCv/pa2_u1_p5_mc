package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public class CuentaBancariaRepository implements ICuentaBancariaRepository {

	private static List<CuentaBancaria> base = new ArrayList<CuentaBancaria>();
	@Override
	public CuentaBancaria seleccionar(String numero) {
		for(CuentaBancaria cuenta:base) {
			if(cuenta.getNumero().equals(numero)) {
				return cuenta;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		base.add(cuentaBancaria);
		System.out.println("Se inserto: "+ cuentaBancaria);

	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.eliminar(cuentaBancaria.getNumero());
		this.insertar(cuentaBancaria);
	
	}

	@Override
	public void eliminar(String numero) {
		CuentaBancaria cuenta = this.seleccionar(numero);
		base.remove(cuenta);

	}

}

