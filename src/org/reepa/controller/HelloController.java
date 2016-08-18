package org.reepa.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController{
	
	
	@RequestMapping("/hi/{username}/{userId}")
	protected ModelAndView hiWorld(@PathVariable Map<String, String> pathParams/*@PathVariable("username") String name, @PathVariable("userId") String id*/) {
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("msg", "Hiiiiii..");
		System.out.println(pathParams.get("username") + ">>> " + pathParams.get("userId"));
		return modelandview;
	}

	/*@RequestMapping("/welcome/{countryName}/{userName}")
	protected ModelAndView helloWorld(@PathVariable String countryName, @PathVariable String userName
			@PathVariable Map<String,String> pathVars) {
		String userName = pathVars.get("userName");
		String countryName = pathVars.get("countryName");
				
				
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("msg", "Hello ".concat(userName).concat(countryName));
		return modelandview;
	}
	
	@RequestMapping("/hi")
	protected ModelAndView hiWorld() {
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("msg", "Hiiiiii..");
		return modelandview;
	}*/

}
