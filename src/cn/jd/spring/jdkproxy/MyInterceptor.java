package cn.jd.spring.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 
 * @author jd
 * @date 2017-6-27上午12:01:19
 * 拦截器作用：
 * 1，引入目标类和事务
 * 2，完成invoke方法
 */
public class MyInterceptor implements InvocationHandler {
	
	private Object target;
	private Transaction transaction;
	
	public MyInterceptor(Object target, Transaction transaction) {
		this.target = target;
		this.transaction = transaction;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		/**
		 * 1,开启事务
		 * 2，完成对象方法
		 * 3，提交事务
		 */
		if(method.getName().equals("savePerson")||
				method.getName().equals("updatePerson")){
			this.transaction.beginTransation();
			method.invoke(this.target, args);//调用目标方法
			this.transaction.commit();
		}else{
			method.invoke(this.target, args);//调用目标方法
		}
		return null;
	}
}
