package kr.co.swl.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.swl.dao.userDaoInterface;
import kr.co.swl.service.userService;
import kr.co.swl.service.userServiceInterface;
import kr.co.swl.util.HttpUtil;

@Controller
public class userController {
	
	@Autowired
	userServiceInterface usi;
	
	@RequestMapping("/user/{menu}/{type}")
	public ModelAndView users(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {

		return usi.users(menu, type, req);
	}
	
	@RequestMapping("/join/{menu}/{type}")
	public ModelAndView join(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {
		
		return usi.users(menu, type, req);
	}
	
	@RequestMapping("/userDel/{menu}/{type}")
	public ModelAndView userDel(@PathVariable("menu") String menu,
							  @PathVariable("type") String type,
							  HttpServletRequest req) {
		
		return usi.userDel(menu, type, req);
	}
	
	@RequestMapping("/level/{menu}/{type}")
	public ModelAndView level(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {
		
		return usi.level(menu, type, req);
	}
	
	@RequestMapping("/msg/{menu}/{type}")
	public ModelAndView msg(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {
		
		return usi.users(menu, type, req);
	}
	
	@RequestMapping("/msgList/{menu}/{type}")
	public ModelAndView msgList(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {
		
		return usi.users(menu, type, req);
	}
	
}
