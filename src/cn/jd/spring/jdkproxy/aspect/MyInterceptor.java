package cn.jd.spring.jdkproxy.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MyInterceptor implements InvocationHandler {
	private List<Interceptor> interceptors;
	private Object target;
	
	public MyInterceptor(List<Interceptor> interceptors,
			Object target) {
		this.interceptors = interceptors;
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		/**
		 * 1,开启日志
		 * 2，开启安全权限
		 * 3，检测权限
		 * 4，查看工资操作
		 */
		for(Interceptor interceptor: interceptors){
			interceptor.interceptor();
		}
		method.invoke(target, args);
		return null;
	}

}
