package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;
@Component
public class HelloSpring {

	
	public void menu(ApplicationContext applicationContext) {
		Scanner scan = new Scanner(System.in);
		UserService userService = null;
		int num;
		while(true) {
			
			System.out.println("""
					************************
					1.입력
					2.출력
					3.수정
					4.삭제
					5.끝
					************************
					
					번호:
					""");
			num = scan.nextInt();
			
			if(num ==5)break;
			if(num==1) {
				userService=(UserService) applicationContext.getBean("userInsertService");
			}else if(num==2) {
				userService=(UserService) applicationContext.getBean("userSelectService");
			}else if(num==3) {
				userService=(UserService) applicationContext.getBean("userUpdateService");
			}else if(num==4) {
				userService=(UserService) applicationContext.getBean("userDeleteService");
			}
			
			userService.execute();
		}
	}
	public static void main(String[] args) {

		//HelloSpring helloSpring =new HelloSpring();
		
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
		helloSpring.menu(applicationContext);
		System.out.println("프로그램을 종료합니다");
	}

}
