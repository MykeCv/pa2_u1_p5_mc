package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

public class TransferenciaRepositoryImpl implements ITransferenciaRepository {
	private static List<Transferencia> base = new ArrayList<Transferencia>();
	@Override
	public Transferencia seleccionar(String numero) {
		// TODO Auto-generated method stub
		for(Transferencia transfer:base) {
			if(transfer.getNumero().equals(numero)) {
				return transfer;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		base.add(transferencia);
		System.out.println("Se inserto: "+ transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
		System.out.println("Se actualiza: "+ transferencia);
	}

	@Override
	public void eliminar(String numero) {
		Transferencia transferencia = this.seleccionar(numero);
		base.remove(transferencia);
	

	}

}
