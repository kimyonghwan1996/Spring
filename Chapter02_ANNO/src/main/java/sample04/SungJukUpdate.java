package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class SungJukUpdate implements SungJuk {
	@Autowired
	@Qualifier("list")
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = sc.next();
		
		int sw = 0;
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2);
				
				System.out.println("수정할 국어 점수 : ");
				int kor = sc.nextInt();
				sungJukDTO2.setKor(kor);
				System.out.println("수정할 영어 점수 : ");
				int eng = sc.nextInt();
				sungJukDTO2.setEng(eng);
				System.out.println("수정할 수학 점수 : ");
				int math = sc.nextInt();
				sungJukDTO2.setMath(math);
				sungJukDTO2.setTot((kor+eng+math));
				sungJukDTO2.setAvg((kor+eng+math)/3.);
				System.out.println();
				
				break;
			}
		}
		
		if(sw == 0) 
			System.out.println("찾는 이름은 없습니다.");
		
	}

}
