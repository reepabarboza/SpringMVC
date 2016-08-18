package org.reepa.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{

	private String listOfHobbies;
	
	@Override
	public void initialize(IsValidHobby isValidHobby) {
		this.listOfHobbies = isValidHobby.listOfHobbies();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		
		if(studentHobby == null) {
			return false;
		}
		
		if(studentHobby.matches(listOfHobbies)){
			return true;
		} else {
			return false;
		}
	}
	
	
}
