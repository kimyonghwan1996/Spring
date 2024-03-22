package user.dao;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Setter;
import user.bean.UserDTO;

@Repository
@Transactional //transaction부르기
public class UserDAOMyBatis implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userDAO.write", userDTO);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUserList2(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("userSQL.getUserList2",id);
	}

	@Override
	public void update(UserDTO userDTO) {
		sqlSession.update("userSQL.update",userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete",id);

	}

}
