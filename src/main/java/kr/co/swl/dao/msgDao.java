package kr.co.swl.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class msgDao implements msgDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public Object msgSelect(HashMap<String, Object> param) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int resultInt = 0;
		String sql = param.get("sql").toString();
		String sqlType = param.get("sqlType").toString();
		if("selectOne".equals(sql)) {
			return session.selectOne(sqlType, param);
		}else if("update".equals(sql)) {
			return session.update(sqlType, param);
		}
		return null;
	}

}
