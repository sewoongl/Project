package kr.co.swl.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.swl.dao.mainDaoInterface;
import kr.co.swl.util.HttpUtil;

@Service
public class mainService implements mainServiceInterface {
	
	@Autowired
	mainDaoInterface mdi;
	
	HashMap<String, Object> param;
	
	@Override
	public ModelAndView contact(String menu, String type, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		
		HashMap<String, Object> map = HttpUtil.getParamMap(req);
		
		param.put("param", map);
		return HttpUtil.makeJsonView(mdi.contact(param));
	}

}
