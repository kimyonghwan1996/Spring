package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 아이디 입력 : ");
		String id = sc.next();
		
		UserDTO userDTO = userDAO.getUserList2(id);

		
		if(userDTO != null) {

			System.out.println("이름\t아이디\t비밀번호");
			System.out.println(userDTO);
			
			userDTO.setId(id);
			System.out.println("수정할 이름 : ");
			String name = sc.next();
			userDTO.setName(name);
			System.out.println("수정할 비밀번호 : ");
			String pwd = sc.next();
			userDTO.setPwd(pwd);
			
			userDAO.update(userDTO);
			System.out.println(id + "님의 데이터를 수정하였습니다.");
			}
		else if(userDTO == null)System.out.println("찾는 아이디가 없습니다");

	}

}
