package cn.jd.spring.cglibproxy;

import org.junit.Test;

public class PersonTest {
	@Test
	public void test(){
		PersonDaoImpl target = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		MyIntercepter myInter = new MyIntercepter(target, transaction);
		PersonDaoImpl proxy = (PersonDaoImpl)myInter.createProxy();
		proxy.save();
	}
}
