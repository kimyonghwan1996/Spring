package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("asQuickStart.xml");
		MessageBean messageBean = applicationContext.getBean("messageBeanImpl",MessageBean.class);
		
		//before
		messageBean.showPrintBefore();
		System.out.println();
		messageBean.viewPrintBefore();
		System.out.println();
		messageBean.display();
		
		//after
		System.out.println("--after--");
		messageBean.showPrintAfter();
		System.out.println();
		messageBean.viewPrintAfter();
		System.out.println();
		messageBean.display();
				
		System.out.println("--around--");
		messageBean.showPrint();
		System.out.println();
		messageBean.viewPrint();
		System.out.println();
		messageBean.display();
	}
}
