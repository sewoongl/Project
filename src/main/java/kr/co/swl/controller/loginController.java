package kr.co.swl.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.swl.dao.loginDaoInterface;
import kr.co.swl.util.FinallUtil;
import kr.co.swl.util.HttpUtil;

@Controller
public class loginController {
	
	@Autowired
	loginDaoInterface ldi;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpSession session) {
		
		HashMap<String, Object> param = HttpUtil.getParamMap(req);
		param.put("sqlType", "swl.login");
		param.put("sql", "selectOne");
		System.out.println(param);
		
		HashMap<String, Object> resultMap = (HashMap<String, Object>) ldi.call(param);
		
		if(resultMap == null) {
			resultMap = new HashMap<String, Object>();
			resultMap.put("status", FinallUtil.NO);
		}else {
			resultMap.put("status", FinallUtil.OK);
		}
		System.out.println(resultMap);
		session.setAttribute("user", resultMap);    //Attribute: 속성  session은 자바에서만 사용 그래서 모델엔뷰로 보내줘야 자바스크립트 쓸수있음
		return HttpUtil.makeJsonView(resultMap);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/resources/ex/index.html";
	}
}
