package kr.co.swl.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class userDao implements userDaoInterface {
	
	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public HashMap<String, Object> users(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		System.out.println("다오파람 :" + param);
		System.out.println("다오타입 :" + param.get("type"));
		System.out.println("다오메뉴 :" + param.get("menu"));
		
		if ("usersList".equals(param.get("type"))) {
			result.put("result", session.selectList(param.get("menu") + ".admList"));
		}
		
		else if ("join2".equals(param.get("type"))) {
			result.put("result", session.selectOne(param.get("menu") + ".joinSes", param.get("id")));
		}
		
		else if ("join".equals(param.get("type"))) {
			result.put("result", session.insert(param.get("menu") + ".join", param.get("param"))); 
		}
		
		else if ("msgSend".equals(param.get("type"))) {
			result.put("msg", session.insert(param.get("menu") + ".msgSend", param.get("param")));
		}
		
		else if ("msgList".equals(param.get("type"))) {
			result.put("result", session.selectList(param.get("menu") + ".msgList"));
		}
		
		else if("userDel".equals(param.get("type"))) {
			result.put("result", session.delete(param.get("menu") + ".userDel", param.get("param")));
		}
		
		else if("level".equals(param.get("type"))) {
			result.put("result", session.delete(param.get("menu") + ".level", param.get("param")));
		}
		
		else if("changePw".equals(param.get("type"))) {
			result.put("result", session.update(param.get("menu") + ".changePw", param.get("param")));
		}
		
		else if("infoDel".equals(param.get("type"))) {
			result.put("result", session.delete(param.get("menu") + ".infoDel", param.get("param")));
		}
		
		return result;
	}

}	
