package kr.co.swl.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView users (String menu, String type, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		
		HashMap<String, Object> map = HttpUtil.getParamMap(req);
		
		param.put("param", map);
		return HttpUtil.makeJsonView(udi.users(param));
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
	
}
