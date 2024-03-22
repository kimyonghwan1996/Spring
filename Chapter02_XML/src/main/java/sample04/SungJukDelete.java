package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukDelete implements SungJuk {
	@Setter
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String name = sc.next();
		int sw = 0;
		
		Iterator<SungJukDTO2> it = list.iterator();
		while(it.hasNext()){ //항목 있으면 true, 없으면 false
			//it가 가리키는 항목을 꺼내서 저장한 후, it는 다음 항목으로 이동
			SungJukDTO2 sungJukDTO2= it.next();
			
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				it.remove(); // 아까 보관한 항목을 제거
				System.out.println(name + " 삭제 완료");
				break; //while 탈출
			}
		}
		
		if(sw == 0) 
			System.out.println("찾는 이름은 없습니다.");
	}

}
