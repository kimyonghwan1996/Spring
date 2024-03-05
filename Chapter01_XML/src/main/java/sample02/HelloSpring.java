package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		
		// MessageKo messageKo = new MessageKo();
		// MessageEn messageEn = new MessageEn();

		MessageBean messageBean = new MessageKo();
		messageBean.sayHello("Spring");
		
		MessageBean messageBean2 = new MessageEn();
		messageBean2.sayHello("Spring");
	}

}
