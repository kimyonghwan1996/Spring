package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;

/*
 * public class UserDAOImpl implements UserDAO{
 * 
 * @Setter private JdbcTemplate jdbcTemplate;
 * 
 * @Override public void write(UserDTO userDTO) { String sql =
 * "insert into usertable values(?,?,?)";
 * jdbcTemplate.update(sql,userDTO.getName(),userDTO.getId(),userDTO.getPwd());
 * // update 가 insert/update/delete
 * 
 * 
 * 
 * 
 * }
 * 
 * @Override public List<UserDTO> getUserList() { String sql =
 * "select * from usertable"; return jdbcTemplate.query(sql, new
 * BeanPropertyRowMapper<UserDTO>(UserDTO.class)); }
 * 
 * }
 */
//---------------------------------------------------------------------------------------
/*
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO{

	@Override 
	public void write(UserDTO userDTO) { 
		String sql ="insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql,userDTO.getName(),userDTO.getId(),userDTO.getPwd());
			  // update 가 insert/update/delete
			  
			  
			  
			  
			  }
			  
	@Override 
	public List<UserDTO> getUserList() { 
		String sql ="select * from usertable"; 
		return getJdbcTemplate().query(sql, new
			  BeanPropertyRowMapper<UserDTO>(UserDTO.class)); }
	
}
*/
//---------------------------------------------------------------------------------------
@Component
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{

	@Autowired
	public UserDAOImpl(BasicDataSource dataSource) {
		setDataSource(dataSource);
	}
	
	
	@Override 
	public void write(UserDTO userDTO) { 
		Map<String,String> map = new HashMap<String,String>();
		map.put("name",userDTO.getName() );
		map.put("id",userDTO.getId() );
		map.put("pwd",userDTO.getPwd() );
		String sql ="insert into usertable values(:name,:id,:pwd)";
		getNamedParameterJdbcTemplate().update(sql,map);
			  // update 가 insert/update/delete
			  }
			  
	@Override 
	public List<UserDTO> getUserList() { 
		String sql ="select * from usertable"; 
		return getJdbcTemplate().query(sql, new
			  BeanPropertyRowMapper<UserDTO>(UserDTO.class)); }

	@Override
	public UserDTO idcheck(String id) {
		String sql ="select * from usertable where id=?";
	    try{
	    	return	getJdbcTemplate().queryForObject(sql
					  , new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
	    }catch(EmptyResultDataAccessException e) {
	    	return null;
	    }
	 
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name",userDTO.getName() );
		map.put("id",userDTO.getId() );
		map.put("pwd",userDTO.getPwd() );
		String sql="update usertable set name=:name,pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql,map);
	}

	
	@Override
	public void userDelete(String id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		String sql ="delete from usertable where id=?";
		getJdbcTemplate().update(sql,id);
		
	}
	
}
