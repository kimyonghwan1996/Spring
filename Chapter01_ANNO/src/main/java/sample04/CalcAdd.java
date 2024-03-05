package sample04;

import org.springframework.stereotype.Component;

@Component("calc")

public class CalcAdd implements Calc {
	
	public CalcAdd() {}

	@Override
	public void Answer(int x, int y) {
		System.out.println(x+ "+" + y + "= " + (x + y));
	}
}
