package com.sibem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibem.models.Saldo;
import com.sibem.repositories.SaldoRepo;

@Service	
public class SaldoServiceImpl implements SaldoService {

	@Autowired
	private SaldoRepo sr;
	
	@Override
	public void save(Saldo saldo) {
		sr.save(saldo);
	}

	@Override
	public Saldo findSaldoById(int id) {
		return sr.findOne(id);
	}

	@Override
	public List<Saldo> getAllSaldo() {
		return sr.findAll();
	}

}
