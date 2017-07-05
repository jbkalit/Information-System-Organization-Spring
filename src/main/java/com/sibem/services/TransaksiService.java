package com.sibem.services;

import java.util.List;

import com.sibem.models.Transaksi;

public interface TransaksiService {

	void save(Transaksi transaksi);

    List<Transaksi> findAllTransaksiById(int id);
    
    List<Transaksi>getAllTransaksi();
    
    Transaksi findTransaksiById(int id);
 
}
