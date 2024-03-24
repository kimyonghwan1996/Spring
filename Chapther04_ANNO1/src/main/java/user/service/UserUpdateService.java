package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Component
public class UserUpdateService implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		
		Scanner scan =new Scanner(System.in);
		
		System.out.print("수정할 아이디 입력: ");
		String id = scan.next();
		UserDTO userDTO = userDAO.idcheck(id);
		
		if(userDTO==null) {
			System.out.println("찾고자 하는 아이디 없음.");
			return;
		}
		
		System.out.println("이름\t아이디\t비밀번호");
		System.out.println(userDTO);
		System.out.print("수정 할 이름입력: ");
		String name = scan.next();
		System.out.print("수정 할 비번입력: ");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setPwd(pwd);
		userDAO.updateUser(userDTO);
		
		System.out.println(id+"님의 데이터수정 완료");
		
		

		
	}

}
		//수정할 아이디 입력 : angel
		//찾고자 하는 아이디 없습니다.
		
		//수정할 아이디입력: hong   ==> queryForObject()
		// 이름 아이디 비밀번호
		//홍길동 hong 111
		
		//수정 할 이름 입력: 홍당무
		//수정 할 비밀번호 입력: 333
		
		//hong 님의 데이터를 수정하였습니다. 