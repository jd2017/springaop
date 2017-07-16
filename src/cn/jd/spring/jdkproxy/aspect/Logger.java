package cn.jd.spring.jdkproxy.aspect;

public class Logger implements Interceptor{
	@Override
	public void interceptor() {
		System.out.println("logger");
	}
}
