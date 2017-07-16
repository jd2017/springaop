package cn.jd.spring.jdkproxy.aspect;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SalaryManagerTest {
	@Test
	public void test(){
		Object target = new SalaryManagerImpl();
		Logger logger = new Logger();
		Privilege privilege = new Privilege();
		List<Interceptor> interceptors = new ArrayList();
		interceptors.add(logger);
		interceptors.add(privilege);
		MyInterceptor myInterceptor =new MyInterceptor(interceptors, target);
		SalaryManager manager = (SalaryManager)Proxy.newProxyInstance(
				target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInterceptor);
		manager.showSalary();
	}
}
