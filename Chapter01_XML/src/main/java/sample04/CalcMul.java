package sample04;

public class CalcMul implements Calc {
	
	public CalcMul() {}
	
	@Override
	public void Answer(int x, int y) {
		System.out.println(x+ "*" + y + "= " + (x * y));
	}
}