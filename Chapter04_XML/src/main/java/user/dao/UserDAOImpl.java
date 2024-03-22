package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;
/*
  public class UserDAOImpl implements UserDAO {
  
  @Setter private JdbcTemplate jdbcTemplate;
  
  @Override public void write(UserDTO userDTO) { String sql =
  "insert into usertable values(?,?,?)"; jdbcTemplate.update(sql,
  userDTO.getName(), userDTO.getId(), userDTO.getPwd()); }
  
  @Override public List<UserDTO> getUserList() { String sql =
  "select * from usertable"; return jdbcTemplate.query(sql, new
  BeanPropertyRowMapper<UserDTO>(UserDTO.class));
  
  } }
*/
//----------------------------------------------------------------------
/*
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	@Override 
	public void write(UserDTO userDTO) { 
		String sql ="insert into usertable values(?,?,?)"; 
		getJdbcTemplate().update(sql,
			  userDTO.getName(), userDTO.getId(), userDTO.getPwd()); 
	}
			  
	@Override 
	public List<UserDTO> getUserList() { 
		String sql ="select * from usertable"; 
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	} 
}
*/


//----------------------------------------------------------------------
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
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
			/*
				return getJdbcTemplate().queryForObject(
		        sql,
		        new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
		        id)
			
			*/
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
