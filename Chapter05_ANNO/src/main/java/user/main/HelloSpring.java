package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;

@Component
public class HelloSpring {
	
	public void menu(ApplicationContext applicationContext) {
		int num;
		Scanner sc = new Scanner(System.in);
		UserService userService = null;
		
		while(true) {
			System.out.println();
			System.out.println("***********************");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 끝");
			System.out.println("***********************");
			System.out.print("번호 : ");
			num = sc.nextInt();
			
			if(num == 5) break;
			else if(num == 1) 
				userService = applicationContext.getBean("userInsertService",user.service.UserService.class);
			else if(num == 2) 
				userService = applicationContext.getBean("userSelectService",user.service.UserService.class);
			else if(num == 3) 
				userService = applicationContext.getBean("userUpdateService",user.service.UserService.class);
			else if(num == 4) 
				userService = applicationContext.getBean("userDeleteService",user.service.UserService.class);
			
			userService.execute();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		//HelloSpring helloSpring = new HelloSpring();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
		helloSpring.menu(applicationContext);
		System.out.println("프로그램 종료");

	}

}
