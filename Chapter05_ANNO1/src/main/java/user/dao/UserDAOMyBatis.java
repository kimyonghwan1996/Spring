package user.dao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMyBatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	//@Transactional
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}
	
	//@Transactional
	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO idCheck(String id) {
		return sqlSession.selectOne("userSQL.idCheck", id);
	}

	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
	}

	@Override
	public void delete(String id) {
		sqlSession.update("userSQL.delete", id);
	}

}
