package sample02;

public class MessageKo implements MessageBean {
	
	public MessageKo() {
		System.out.println("MessageKo 기본생성자");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하슈 "+name);
		
	}

}