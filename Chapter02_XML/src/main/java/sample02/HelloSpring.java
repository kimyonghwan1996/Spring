package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calc calcAdd = applicationContext.getBean("calcAdd",Calc.class);
		Calc calcMul = applicationContext.getBean("calcMul",Calc.class);
		calcAdd.calcuate();
		calcMul.calcuate();
	}

}
