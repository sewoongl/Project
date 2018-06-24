package kr.co.swl.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.swl.dao.userDaoInterface;
import kr.co.swl.util.HttpUtil;

@Service
public class userService implements userServiceInterface {
	
	@Autowired
	userDaoInterface udi;
	
	HashMap<String, Object> param;
	
	@Override
	public ModelAndView users (String menu, String type, HttpServletRequest req, HttpSession ses) {
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		
		HashMap<String, Object> map = HttpUtil.getParamMap(req);
		System.out.println("0. 가져온 파라미터값 : " + map);
		String id = map.get("id").toString();
		System.out.println("1. 입력한 아이디값 : " + id);
		param.put("param", map);
		int status = (int) udi.users(param).get("result");
		System.out.println("2. insert 성공유무 : " + status);
		param.put("type", "join2");
		param.put("id", id);
		System.out.println("현재 param 내용 : " + param);
		if (status == 1) {
			HashMap<String, Object> resultMap = (HashMap<String, Object>) udi.users(param).get("result");
			System.out.println("3. Login용 select문 결과 : " + resultMap);
			ses.setAttribute("user", resultMap);
		}else {
			System.out.println("회원가입 실패");
		}
		
		return HttpUtil.makeJsonView(map); //원래값 udi.users(param)
	}

	@Override
	public ModelAndView userDel(String menu, String type, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		
		HashMap<String, Object> map = HttpUtil.getParamMap(req);
		HashMap<String, Object> result = new HashMap<String, Object>();
		
			param.put("param",map);
			result = udi.users(param);
		
		return HttpUtil.makeJsonView(result);
	}
	
	@Override
	public ModelAndView level(String menu, String type, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		
		HashMap<String, Object> map = HttpUtil.getParamMap(req);
		HashMap<String, Object> result = new HashMap<String, Object>();
		
			param.put("param",map);
			result = udi.users(param);
		
		return HttpUtil.makeJsonView(result);
	}

	@Override
	public HashMap<String, Object> joinSes(HttpServletRequest req, HttpSession session) {
		String id = req.getParameter("id");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("sql", "selectOne");
		map.put("sqlType", "swl.joinSes");
		map = udi.users(map);
		System.out.println(map);
		
//		id -> DB
//		DB -> map
		
//		session.setAttribute("user", );
		return map;
	}

	
}
