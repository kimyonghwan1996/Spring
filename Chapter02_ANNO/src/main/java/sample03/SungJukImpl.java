package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	// 생성된 bean중에서 SungjukDTO를 찾아서 자동으로 맵핑 함 
	// 생성자이든 Setter이든 상관없이 SungjukDTO를 찾아서 자동으로 맵핑 함 
	@Autowired
	private SungjukDTO sungjukDTO = null;
	
	@Override
	public void calcTot() {
		sungjukDTO.setTot(sungjukDTO.getKor() + sungjukDTO.getEng() + sungjukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungjukDTO.setAvg(sungjukDTO.getTot()/3.);
	}
	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungjukDTO.getName()+"\t" + 
						   sungjukDTO.getKor()+"\t" + 
						   sungjukDTO.getEng()+"\t" + 
						   sungjukDTO.getMath()+"\t" + 
						   sungjukDTO.getTot()+"\t" + 
						   String.format("%.2f", sungjukDTO.getAvg()));
		System.out.println(sungjukDTO);
	}

	@Override
	public void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름입력 : ");
		sungjukDTO.setName(sc.next());
		System.out.println("국어입력 : ");
		sungjukDTO.setKor(sc.nextInt());
		System.out.println("영어입력 : ");
		sungjukDTO.setEng(sc.nextInt());
		System.out.println("수학입력 : ");
		sungjukDTO.setMath(sc.nextInt());
		
		
	}

}
