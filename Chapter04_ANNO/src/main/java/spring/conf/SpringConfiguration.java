package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import user.bean.UserDTO;
import user.dao.UserDAOImpl;
import user.main.HelloSpring;

@Configuration
@PropertySource("classpath:spring/db.properties") //<context:property-placeholder location="classpath:spring/db.properties"/>
public class SpringConfiguration {
//	private @Value("${jdbc.driver}") String driver;
//	private @Value("${jdbc.url}") String url;
//	private @Value("${jdbc.username}") String username;
//	private @Value("${jdbc.password}") String password;
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		basicDataSource.setUsername("jdbc:mysql://localhost:3306/mydb?serverTimezone=Asia/Seoul");
//		basicDataSource.setUsername("root");
//		basicDataSource.setPassword("1234");
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
	}

}
