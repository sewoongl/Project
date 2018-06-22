package kr.co.swl.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.swl.dao.msgDaoInterface;
import kr.co.swl.util.HttpUtil;

@Controller
public class msgController {
	
	@Autowired
	msgDaoInterface mdi;
	
	@RequestMapping("/msgOne")
    public ModelAndView msgOne(HttpServletRequest req) {
    	String msgNo = req.getParameter("msgNo");
    	HashMap<String, Object> param = new HashMap<String, Object>();
    	param.put("msgNo", msgNo);
    	
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	param.put("sqlType","swl.msgOne");
    	param.put("sql","selectOne");
    	resultMap.put("msgData", mdi.msgSelect(param));
    	  	
    	return HttpUtil.makeJsonView(resultMap);
    }
	
	@RequestMapping("/msgDel")
	public ModelAndView msgDel(HttpServletRequest req) {
		String msgDel = req.getParameter("msgNo");
//		System.out.println("델델" +msgDel);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("msgDel", msgDel);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		param.put("sqlType","swl.msgDel");
    	param.put("sql","update");
    	resultMap.put("msgData", mdi.msgSelect(param));
		return HttpUtil.makeJsonView(resultMap);
	}
}
