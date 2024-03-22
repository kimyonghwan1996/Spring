package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageBeanImpl implements MessageBean {

	private String str;
	
	@Autowired
	public void setStr(@Value("hello") String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore() = " + str); //핵심코드
		
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // 1초
		
		System.out.println("viewPrintBefore() = " + str); 
		
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter() = " + str); //핵심코드
		
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // 1초
		
		System.out.println("viewPrintAfter() = " + str); 
		
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint() = " + str); 
		return "스프링";
		
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("viewPrint() = " + str); 
		
	}
	@Override
	public void display() {
		System.out.println("display() = " + str); 
		
	}
}
