package sample05;

public class SjungjukImpl implements SungJuk {
	public SjungjukImpl() {}
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private int avg;
	
	public void calc(int kor, int eng, int math) {
		tot = kor + eng + math;
		avg = tot/3;
	}
	
	public void display(String name,int kor, int eng, int math) {
		System.out.println("이름  국어 영어 수학 총점 평균");
		System.out.println(name+" " + kor+" " + eng+"  " + math+" " + tot+" " + avg);
	}
}
