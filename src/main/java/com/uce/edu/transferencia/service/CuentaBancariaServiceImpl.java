package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.insertar(cuentaBancaria);
		
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.actualizar(cuentaBancaria);
		
	}

	@Override
	public void eliminar(String numero) {
		this.bancariaRepository.eliminar(numero);
		
	}
	
	@Override
	public void Depositar(BigDecimal deposito, String ctaDestino) {
		CuentaBancaria cta = this.bancariaRepository.seleccionar(ctaDestino);
		BigDecimal impuesto = deposito.multiply(BigDecimal.valueOf(0.90));
		cta.setSaldo(cta.getSaldo().add(impuesto));
		this.bancariaRepository.actualizar(cta);
		
		
	}

}
