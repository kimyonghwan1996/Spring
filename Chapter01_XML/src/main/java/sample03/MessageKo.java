package sample03;

public class MessageKo implements MessageBean {
	private int num;
	
	
	public MessageKo() {
		System.out.println("MessageKo 기본생성자");
	}
	
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num = " + num);
		System.out.println("안녕하슈 "+name);
		
	}

}