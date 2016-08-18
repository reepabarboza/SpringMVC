package org.reepa.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws IOException {
		
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		if(dayOfWeek == 5) {
			resp.getWriter().write("The website is closed on Sunday");
			return false;
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView model) throws Exception {
		
		System.out.println("postHandle method called after executing getAdmissionForm method of StudentAdmissionController class");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) throws IOException {
		
		System.out.println("after completion called after the response object is produced by the view of the req: here afre admissionform is displayed");
	}

}
