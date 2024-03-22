package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample02.CalcAdd;
import sample02.CalcMul;
import sample04.SungJukDTO2;
import smaple01.MessageBeanImpl;

@Configuration
	public class SpringConfiguration {
	
	//bean 생성
	
	//sample01
//	@Bean
//	public MessageBeanImpl messageBeanImpl(){
//		return new MessageBeanImpl("사과"); 
//	}
	
	@Bean(name="messageBeanImpl")
	public MessageBeanImpl getMessageBeanImpl(){
		return new MessageBeanImpl("사과"); 
	}
	
	//sample02
	@Bean
	public CalcAdd calcAdd(){
		return new CalcAdd(25,36); 
	}
	
	@Bean(name="calcMul")
	public CalcMul getCalcMul(){
		return new CalcMul(); 
	}
	
	//sample04
	@Bean
	public List<SungJukDTO2> list(){
		return new ArrayList<SungJukDTO2>();
	}

}
/*
  @Bean
  -> 메소드에서 return되는 값을 스프링의 bean으로 생성
  -> 메소드명을 설정할 때에는 반드시 bean의 id명으로 설정
  -> 메소드명을 설정할 때에는 java처럼 getter 사용하려면 @Bean(name="")을 사용한다 
 */