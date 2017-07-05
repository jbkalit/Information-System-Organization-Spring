package com.sibem.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sibem.models.Mahasiswa;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Mahasiswa> {

	@Override
	public void initialize(PasswordMatch constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Mahasiswa user, ConstraintValidatorContext context) {
		String plainPassword = user.getPlainPassword();
		String repeatPasword = user.getRepeatPassword();
		
		if(plainPassword == null || plainPassword.length() == 0){
			return true;
		}
		
		if(plainPassword==null || !plainPassword.equals(repeatPasword)){
			return false;
		}
		
		return true;
	}

}
