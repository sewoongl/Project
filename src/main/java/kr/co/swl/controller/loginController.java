package kr.co.swl.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.swl.dao.loginDaoInterface;
import kr.co.swl.util.FinallUtil;
import kr.co.swl.util.HttpUtil;

@Controller
public class loginController {
	
	@Autowired
	loginDaoInterface ldi;

	@RequestMapping("/userLogin")
	public String userLogin(HttpServletRequest req, RedirectAttributes attr, HttpSession session) {
//		System.out.println("hihihiihhihih");
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
		
		session.setAttribute("user", resultMap);
		return "redirect:/resources/ex/index.html";
	}
}
