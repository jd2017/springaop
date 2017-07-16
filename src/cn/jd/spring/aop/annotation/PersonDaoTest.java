package cn.jd.spring.aop.annotation;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDaoTest {
	@Test
	public void test(){	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	PersonDao person =(PersonDao)context.getBean("personDao");
	person.save();
	}
}
