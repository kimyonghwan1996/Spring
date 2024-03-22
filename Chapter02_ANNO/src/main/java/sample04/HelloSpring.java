package sample04;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component //빈설정하는거랑 마찬가지
public class HelloSpring {
	@Autowired
	public void menu(ApplicationContext applicationContext) {
		Scanner sc = new Scanner(System.in);
		SungJuk sungJuk = null;
		while(true) {
			System.out.println("***********************");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 끝");
			System.out.println("***********************");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			if(num == 5) break;
			
			else if(num == 1) 
				sungJuk = applicationContext.getBean("sungJukInput",SungJuk.class);
			else if(num == 2) 
				sungJuk = applicationContext.getBean("sungJukOutput",SungJuk.class);
			else if(num == 3) 
				sungJuk = applicationContext.getBean("sungJukUpdate",SungJuk.class);
			else if(num == 4) 
				sungJuk = applicationContext.getBean("sungJukDelete",SungJuk.class);
			
			sungJuk.execute();
			System.out.println();
		}
	}
	public static void main(String[] args) {
		//HelloSpring helloSpring = new HelloSpring();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = applicationContext.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(applicationContext);
	}

}
