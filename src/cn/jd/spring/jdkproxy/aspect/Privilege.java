package cn.jd.spring.jdkproxy.aspect;

public class Privilege  implements Interceptor{

	@Override
	public void interceptor() {
		System.out.println("privilege");
	}
	
}
