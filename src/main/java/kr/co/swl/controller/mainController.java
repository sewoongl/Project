package kr.co.swl.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.swl.service.mainServiceInterface;

@Controller
public class mainController {
	
	@Autowired
	mainServiceInterface msi;
	
	@RequestMapping("/contact/{menu}/{type}")
	public ModelAndView users(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {

		return msi.contact(menu, type, req);
	}
	
	
}
