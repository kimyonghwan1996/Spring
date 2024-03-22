package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;
@Service
public class UserDeleteService implements UserService {
	@Autowired
	private UserDTO userDTO; //없어도됨
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 아이디 입력 : ");
		String id = sc.next();
		
		userDTO = userDAO.getUserList2(id);
		
		if(userDTO != null) {

			System.out.println("이름\t아이디\t비밀번호");
			System.out.println(userDTO);

			userDAO.delete(id);
			System.out.println(id + "님의 데이터를 삭제하였습니다.");
			}
		else System.out.println("찾는 아이디가 없습니다");

		

	}

}
