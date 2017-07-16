package cn.jd.spring.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyIntercepter implements MethodInterceptor {
	private Object target;
	private Transaction transaction;	
	public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		//设置代理父类：目标类
		enhancer.setSuperclass(this.target.getClass());
		return enhancer.create();
	}
	public MyIntercepter(Object target, Transaction transaction) {
		this.target = target;
		this.transaction = transaction;
	}
	@Override
	public Object intercept(Object arg0, Method method, Object[] args,
			MethodProxy arg3) throws Throwable {
		this.transaction.beginTransation();
		method.invoke(target, args);
		this.transaction.commit();
		
		return null;
	}

}
