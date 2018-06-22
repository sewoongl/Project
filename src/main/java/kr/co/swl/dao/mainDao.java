package kr.co.swl.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class mainDao implements mainDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public HashMap<String, Object> contact(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
//		System.out.println(param.get("type"));
		
		if ("contact".equals(param.get("type"))) {
			result.put("result", session.selectList(param.get("menu") + ".contactList"));
		}
//		System.out.println(result);
		return result;
	}
}