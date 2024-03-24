package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.SqlSessionFactory;

import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMyBatis implements UserDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDTO isExistId(String id) {
		return sqlSession.selectOne("userSQL.isExistId", id);
	}

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
		
	}

//	@Override
//	public List<UserDTO> getUserList(String pg) {
//		
//		return sqlSession.selectList("userSQL.getUserList", pg);
//	}

	@Override
	public List<UserDTO> getUserList(int startNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("startNum", startNum);
//		map.put("endNum", endNum);
		map.put("startNum", startNum -1);
		map.put("endNum", 3);

		return sqlSession.selectList("userSQL.getUserList", map);
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("userSQL.getTotalA");
	}

	@Override
	public UserDTO getUserList(String id) {

		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void update(UserDTO userDTO) {
		sqlSession.update("userSQL.write", userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
		
	}


}
