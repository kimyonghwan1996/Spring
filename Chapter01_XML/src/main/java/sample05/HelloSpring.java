package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SjungjukImpl sjungjukImpl = (SjungjukImpl) applicationContext.getBean("calc3"); //부모 = 자식
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		sjungjukImpl.calc(kor, eng, math);
		sjungjukImpl.display(name,kor, eng, math);
	}

}