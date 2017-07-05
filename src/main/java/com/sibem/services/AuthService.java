package com.sibem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.sibem.models.Mahasiswa;
import com.sibem.repositories.MahasiswaRepo;
     



@Service
public class AuthService implements UserDetailsService {

	
	@Autowired
	private MahasiswaRepo mhsRepo;

	
	public void register(Mahasiswa mhs){
		mhs.setRole("ROLE_MAHASISWA");
		mhsRepo.save(mhs);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String nim) throws UsernameNotFoundException {
		Mahasiswa mhs = mhsRepo.findByNim(nim);

		if(mhs==null){
			System.out.println("UsernameNotFoundException: Username not found for nim =====> "+ nim );
			throw new UsernameNotFoundException("Mahasiswa not found");
		}
		
		System.out.println("===================================");
		System.out.println("Nama\t:"+mhs.getFullname());
		System.out.println("Role\t:"+mhs.getRole());
		System.out.println("===================================");
		
		List<GrantedAuthority> auth=AuthorityUtils.commaSeparatedStringToAuthorityList(mhs.getRole());
		String password = mhs.getPassword();
		
		return new User(nim,password,auth);
	}

}
