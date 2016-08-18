package org.reepa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****mm****dd");
		binder.registerCustomEditor(Date.class, "studentDob", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
	@RequestMapping(value = "admissionForm.html", method = RequestMethod.GET)
	protected ModelAndView getAdmissionForm() {
		
		
		/*String test = null;
		if(test == null) {
			throw new NullPointerException();
		}*/
		
		ModelAndView model = new ModelAndView("AdmissionForm");
		//model.addObject("headerMessage", "Student's admission form");
		return model;
	}
	
	/*@RequestMapping(value = "submitAdmissionForm.html", method = RequestMethod.POST)
	protected ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue = "Reepa") String name, 
			@RequestParam(value = "studentHobby" , defaultValue = "Reepa") String hobby
			@RequestParam Map<String, String> pathVars) {
		
		Student student1 = new Student();
		student1.setStudentName(name);
		student1.setStudentHobby(hobby);
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		
		String name = pathVars.get("studentName");
		String hobby = pathVars.get("studentHobby");
		
		model.addObject("msg", "Admission success");
		model.addObject("student1", student1);

		return model;
	}*/
	
	
	@ModelAttribute
	protected void addingCommonObjects(Model model) {
		model.addAttribute("headerMessage", "Students Info");
	}
	
	@RequestMapping(value = "submitAdmissionForm.html", method = RequestMethod.POST)
	protected ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student, BindingResult result) {
		
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		
		//model.addObject("headerMessage", "Admission successful");
		return model;
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointeException() {
		return "NullPointerException";
	}
}
