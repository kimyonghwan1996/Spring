package sample03;

public class MessageEn implements MessageBean {

	public MessageEn() {
		System.out.println("MessageEn 기본생성자");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name);
		
	}

}
