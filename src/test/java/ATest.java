


import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ATest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext content = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
		content.start();
		Object dataSource = content.getBean("dataSource");
		System.out.println(dataSource);
	}

	
}