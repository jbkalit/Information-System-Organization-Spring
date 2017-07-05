package com.sibem.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sibem.models.Mahasiswa;
import com.sibem.services.AuthService;

@Controller
public class AuthController {

	@Autowired
	AuthService authService;
	
	@RequestMapping(value = "/login")
	String admin(){
		return "login";
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	ModelAndView register(ModelAndView mv, Model model){

		
		Mahasiswa mhs= new Mahasiswa();
		mv.getModel().put("mhs", mhs);
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	ModelAndView register(ModelAndView modelAndView, @Valid @ModelAttribute("mhs") Mahasiswa mhs, BindingResult result) {
		modelAndView.setViewName("register");
		if(!result.hasErrors()){
			authService.register(mhs);
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
	
	 @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
		public String logout(){
			
			return "redirect:/";
		}
	
}
