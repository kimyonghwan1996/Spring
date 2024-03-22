package sample05;

import java.util.Scanner;

public class SjungjukImpl implements SungJuk {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private int avg;
	
	public SjungjukImpl() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("국어 : ");
		kor = sc.nextInt();
		
		System.out.print("영어 : ");
		eng = sc.nextInt();
		
		System.out.print("수학 : ");
		math = sc.nextInt();
	}
	
	@Override
	public void calc() {
		tot = kor + eng + math;
		avg = tot/3;
	}
	
	@Override
	public void display() {
		System.out.println("이름  국어 영어 수학 총점 평균");
		System.out.println(name+" " + kor+" " + eng+"  " + math+" " + tot+" " + avg);
	}
}
