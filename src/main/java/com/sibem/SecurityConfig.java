package com.sibem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sibem.services.AuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
				.antMatchers("/","/register").permitAll()
				.antMatchers("/js/*","/css/*","/img/*").permitAll()
				.antMatchers("/kominfo").hasAnyRole("KADEP","ADMIN")
				.antMatchers("/create/iuran").hasAnyRole("BENDAHARA","ADMIN")
				.antMatchers("/edit/iuran").hasAnyRole("BENDAHARA","ADMIN")
				.antMatchers("/create/pengumuman").hasAnyRole("ADMIN", "KETUA","KADEP","BENDAHARA","SEKRETARIS","BEKEL")
				.antMatchers("/edit/pengumuman").hasAnyRole("ADMIN", "KETUA","KADEP","BENDAHARA","SEKRETARIS","BEKEL")
				.antMatchers("/create/program/kerja").hasAnyRole("ADMIN","KADEP")
				.antMatchers("/create/mahasiswa").hasRole("ADMIN")
				.antMatchers("/create/prodi").hasRole("ADMIN")
				.antMatchers("/create/pengurus").hasRole("ADMIN")
				.antMatchers("/create/jabatan").hasRole("ADMIN")
				.antMatchers("/view/iuran").hasAnyRole("ADMIN","BEKEL","BENDAHARA")
				.antMatchers("/view/laporan/keuangan").hasAnyRole("ADMIN","BENDAHARA")
				.antMatchers("/semua/program-umum").hasAnyRole("ADMIN", "KETUA","KADEP","BENDAHARA","SEKRETARIS","BEKEL")
				.antMatchers("/view/rekapitulasi").hasAnyRole("ADMIN", "KETUA","KADEP","BENDAHARA","SEKRETARIS","BEKEL")

				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authService).passwordEncoder(passwordEncoder);
	}

}
