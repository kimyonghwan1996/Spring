package user.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional //transaction부르기
public class UserDAOMyBatis implements UserDAO {
	
	@Setter
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userDTO.write", userDTO);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUserList2(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("id",id);
	}

	@Override
	public void update(UserDTO userDTO) {
		sqlSession.update("userSQL.update",userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete(id);

	}

}
