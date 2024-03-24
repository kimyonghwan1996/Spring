package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Component
public class UserDeleteService implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Override
	public void execute() {
		

		Scanner scan =new Scanner(System.in);
		
		System.out.print("삭제할 아이디 입력: ");
		String id = scan.next();
		
		UserDTO userDTO = userDAO.idcheck(id);
		if(userDTO==null) {
			System.out.println("찾고자 하는 아이디 없음.");
		}else {
			userDAO.userDelete(id);
			System.out.println(id+"님의 데이터삭제 완료");
		}
		
	}

}

		//삭제할 아이디 입력 : angel
		//찾고자 하는 아이디 없습니다.
			
		//삭제할 아이디입력: hong
		//hong 님의 데이터를 삭제하였습니다.