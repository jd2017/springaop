package cn.jd.spring.jdkproxy.salary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInterceptor implements InvocationHandler {
	private Logger logger;
	private Security security;
	private Privilege privilege;
	private Object target;
	
	public MyInterceptor(Logger logger, Security security, Privilege privilege,
			Object target) {
		this.logger = logger;
		this.security = security;
		this.privilege = privilege;
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
			this.logger.logger();
			this.security.security();
			if(this.privilege.getAccess().equals("admin")){
				method.invoke(target, args);
			}else{
				System.out.println("权限不足");
			}
		return null;
	}

}
