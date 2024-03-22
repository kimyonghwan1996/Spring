package sample02;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class CalcMul implements Calc {
	@Setter
	private int x, y;

	@Override
	public void calcuate() {
		System.out.println(x+ "*" + y + "= " + (x * y));
		
	}

}
