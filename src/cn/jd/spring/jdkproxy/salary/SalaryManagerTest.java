package cn.jd.spring.jdkproxy.salary;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class SalaryManagerTest {
	@Test
	public void test(){
		Object target = new SalaryManagerImpl();
		Logger logger = new Logger();
		Security security =new Security();
		Privilege privilege = new Privilege();
		privilege.setAccess("admin1");
		MyInterceptor myInterceptor =new MyInterceptor(logger, security, privilege, target);
		SalaryManager manager = (SalaryManager)Proxy.newProxyInstance(
				target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInterceptor);
		manager.showSalary();
	}
}
