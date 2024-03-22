package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;


public class UserInsertService implements UserService {
	@Setter
	private UserDTO userDTO;
	@Setter
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		userDTO.setName(sc.next());
		System.out.println("아이디 입력 : ");
		userDTO.setId(sc.next());
		System.out.println("비밀번호 입력 : ");
		userDTO.setPwd(sc.next());
		
		userDAO.write(userDTO);
		System.out.println("입력완료");
	}

}
