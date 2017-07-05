package com.sibem.services;

import java.util.List;

import com.sibem.models.ProgramKerja;

public interface ProgramKerjaService {

	void save(ProgramKerja programkerja);
   
    List<ProgramKerja>getAllProgramKerja();
    
    ProgramKerja findProgramKerjaById(int id);
 
}
