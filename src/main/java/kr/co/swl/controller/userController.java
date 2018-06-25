package kr.co.swl.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/usersList/{menu}/{type}")
	public ModelAndView usersList(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {

		return usi.usersList(menu, type, req);
	}
	
	@RequestMapping("/user/{menu}/{type}")
	public ModelAndView users(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req, HttpSession ses) {

		return usi.users(menu, type, req, ses);
	}
	
	@RequestMapping("/join/{menu}/{type}")
	public ModelAndView join(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req, HttpSession ses) {
		
		return usi.users(menu, type, req, ses);
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
			HttpServletRequest req, HttpSession ses) {
		
		return usi.msg(menu, type, req);
	}
	
	@RequestMapping("/msgList/{menu}/{type}")
	public ModelAndView msgList(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req, HttpSession ses) {
		
		return usi.msg(menu, type, req);
	}
	
	@RequestMapping("/infoData")
	public ModelAndView infoData(HttpSession ses) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Object user = ses.getAttribute("user");
		map.put("user", user);
		
		return HttpUtil.makeJsonView(map);
	}
	
	@RequestMapping("/joinSes")
	public ModelAndView joinSes(HttpServletRequest req, HttpSession session) {
		return HttpUtil.makeJsonView(usi.joinSes(req,session));
	}
	
	@RequestMapping("/changePw/{menu}/{type}")
	public ModelAndView changePw(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req, HttpSession ses) {
		
		return usi.changePw(menu, type, req);
	}
	
	@RequestMapping("/infoDel/{menu}/{type}")
	public ModelAndView infoDel(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req, HttpSession ses) {
		
		return usi.infoDel(menu, type, req, ses);
	}
}
