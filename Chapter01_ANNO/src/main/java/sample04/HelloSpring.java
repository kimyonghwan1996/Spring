package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calc calc = (Calc) applicationContext.getBean("calc"); //부모 = 자식
		Calc calc2 = applicationContext.getBean("calc2", Calc.class); //부모 = 자식
		
		calc.Answer(1,2);
		calc2.Answer(1,2);
	}
}