package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Setter;


public class SungJukInput implements SungJuk {
	@Setter
	private SungJukDTO2 sungJukDTO2 = null;
	@Setter
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름입력 : ");
		sungJukDTO2.setName(sc.next());
		System.out.println("국어입력 : ");
		int kor = sc.nextInt();
		sungJukDTO2.setKor(kor);
		System.out.println("영어입력 : ");
		int eng = sc.nextInt();
		sungJukDTO2.setEng(eng);
		System.out.println("수학입력 : ");
		int math = sc.nextInt();
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot((kor+eng+math));
		sungJukDTO2.setAvg((kor+eng+math)/3.);
		list.add(sungJukDTO2);
	}



}
