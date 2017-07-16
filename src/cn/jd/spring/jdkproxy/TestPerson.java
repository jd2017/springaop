package cn.jd.spring.jdkproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestPerson {
	@Test
	public void test(){
		/**
		 * 1,创建目标类对象；
		 * 2，创建事务；
		 * 3，产生代理对象
		 * 4，代理对象调用方法
		 */
		Object target = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		MyInterceptor myInterceptor = new MyInterceptor(target, transaction);
		/**
		 * 1，参数一loader：类加载器
		 * 2，参数二interfaces:所有的接口类对象
		 * 3，拦截器
		 */
		PersonDao person = (PersonDao)Proxy.newProxyInstance(
				target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInterceptor);
		person.save();
	}
}
