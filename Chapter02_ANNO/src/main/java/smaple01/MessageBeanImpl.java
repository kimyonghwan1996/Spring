package smaple01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Component
public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int cost;
	private int qty;
	
	//생성자 Injection
	public MessageBeanImpl(@Value("사과") String fruit) {
		this.fruit = fruit;
	}
	
	//Setter Injection
	@Autowired
	public void setCost(@Value("4000") int cost) {
		this.cost = cost;
	}
	@Autowired
	public void setQty(@Value("3") int qty) {
		this.qty = qty;
	}
	
	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);

	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);

	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);

	}

}
