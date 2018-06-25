package kr.co.swl.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface userServiceInterface {
	
	public ModelAndView usersList( String menu, String type, HttpServletRequest req);
	
	public ModelAndView users( String menu, String type, HttpServletRequest req, HttpSession ses);
	
	public ModelAndView msg( String menu, String type, HttpServletRequest req);
	
	public ModelAndView changePw( String menu, String type, HttpServletRequest req);
	
	public ModelAndView userDel( String menu, String type, HttpServletRequest req);
	
	public ModelAndView level( String menu, String type, HttpServletRequest req);
	
	public ModelAndView infoDel( String menu, String type, HttpServletRequest req, HttpSession ses);
	
	public HashMap<String, Object> joinSes(HttpServletRequest req, HttpSession session);
	
}
