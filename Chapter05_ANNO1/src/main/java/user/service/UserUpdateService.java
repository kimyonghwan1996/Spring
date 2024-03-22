package user.service;

import java.util.HashMap;
import java.util.Map;
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
		System.out.println();
		Scanner scan =new Scanner(System.in);
		
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		UserDTO userDTO = userDAO.idCheck(id);
		
		if(userDTO==null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}
		
		System.out.println("이름\t아이디\t비밀번호");
		System.out.println(userDTO);
		
		System.out.println();
		System.out.print("수정 할 이름 입력 : ");
		String name = scan.next();
		System.out.print("수정 할 비밀번호 입력 : ");
		String pwd = scan.next();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.update(map);
			
		System.out.println( id + "님의 데이터를 수정하였습니다.");
	}

}






