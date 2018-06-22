package kr.co.swl.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface userServiceInterface {
	
	public ModelAndView users( String menu, String type, HttpServletRequest req);
	
	public ModelAndView userDel( String menu, String type, HttpServletRequest req);
	
	public ModelAndView level( String menu, String type, HttpServletRequest req);
}
