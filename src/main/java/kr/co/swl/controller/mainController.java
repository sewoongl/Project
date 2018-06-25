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

import kr.co.swl.service.mainServiceInterface;
import kr.co.swl.util.HttpUtil;

@Controller
public class mainController {
	
	@Resource(name = "sqlSession")
	SqlSession session;
	
	@Autowired
	mainServiceInterface msi;
	
	@RequestMapping("/contact/{menu}/{type}")
	public ModelAndView users(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {

		return msi.contact(menu, type, req);
	}
	
	@RequestMapping("/aboutList")
	public ModelAndView aboutList() {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		HashMap<String, Object> profile = session.selectOne("swl.profileList");
		
		List<HashMap<String, Object>> resumeI = session.selectList("swl.resumeI");  //selecList() 메소드의 타입은 List이다.
		List<HashMap<String, Object>> resumeR = session.selectList("swl.resumeR");
		List<HashMap<String, Object>> resumeS = session.selectList("swl.resumeS");
		
		resultMap.put("resumeI", resumeI);
		resultMap.put("resumeR", resumeR);
		resultMap.put("resumeS", resumeS);
		resultMap.put("profile", profile);
		
		return HttpUtil.makeJsonView(resultMap);
	}
	
	@RequestMapping("/boardList")
	public ModelAndView boardList(HttpServletRequest req) {
		
		String boardNo = req.getParameter("boardNo");
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<HashMap<String, Object>> mainboard = session.selectList("swl.mainboard"); //boardNo를 넘겨주자 쿼리문에 맞게
		
		resultMap.put("mainboard", mainboard);
		resultMap.put("boardNo", boardNo);
		
		return HttpUtil.makeJsonView(resultMap);
	}
	
}
