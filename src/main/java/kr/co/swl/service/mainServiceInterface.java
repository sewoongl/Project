package kr.co.swl.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface mainServiceInterface {
	
	public ModelAndView contact( String menu, String type, HttpServletRequest req);
}
