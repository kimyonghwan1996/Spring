package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import user.bean.UserDTO;

@Repository //DB와 연동하는 Bean일때
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Autowired
	//JdbcDaoSupport의 setDataSource가 final이기 때문에 override를 할 수 없음 
	public void setDS(DataSource dataSource) { 
		setDataSource(dataSource);//JdbcDaoSupport의 setDataSource 호출
	}
	
//	public UserDAOImpl(DataSource dataSource) {
//		setDataSource(dataSource);
//	}
	
	
	@Override 
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		String sql ="insert into usertable values(:name,:id,:pwd)";
		getNamedParameterJdbcTemplate().update(sql, map);

	}
			  
	@Override 
	public List<UserDTO> getUserList() { 
		String sql ="select * from usertable";
		return getNamedParameterJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	
	@Override
	public UserDTO getUserList2(String id) {
		String sql ="select * from usertable where id =:id";
		try {
		    return getNamedParameterJdbcTemplate().queryForObject(
		        sql,
		        new MapSqlParameterSource("id", id),
		        new BeanPropertyRowMapper<>(UserDTO.class)
		    );
		} catch (EmptyResultDataAccessException e) {
		    return null; 
		}
	} 

	@Override
	public void update(UserDTO userDTO) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());

		String sql ="update usertable set name = :name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);

	}

	@Override
	public void delete(String id) {
		
		String sql ="delete from usertable where id=:id";
		getNamedParameterJdbcTemplate().update(sql, new MapSqlParameterSource("id", id));
		
	}

}
