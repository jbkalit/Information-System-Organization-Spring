package com.sibem.services;

import java.util.List;

import com.sibem.models.Prodi;
import com.sibem.models.Saldo;

public interface SaldoService {
	
	void save(Saldo saldo);
    Saldo findSaldoById(int id);    
    List<Saldo>getAllSaldo();

}
