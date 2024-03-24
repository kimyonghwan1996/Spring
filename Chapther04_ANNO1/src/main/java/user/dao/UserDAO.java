package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public UserDTO idcheck(String id);

	public void updateUser(UserDTO userDTO);

	public void userDelete(String id);
	
}
