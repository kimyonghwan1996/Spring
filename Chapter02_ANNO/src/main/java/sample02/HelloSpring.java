package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calc calc = applicationContext.getBean("calcAdd",Calc.class);
		calc.calcuate();
		
		calc = applicationContext.getBean("calcMul",Calc.class);
		calc.calcuate();
	}

}
