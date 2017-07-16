package cn.jd.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Transaction {
	public void beginTransaction(JoinPoint joinPoint){
//		连接点名称
		System.out.println("连接点名称"+joinPoint.getSignature().getName());
//		连接点目标
		System.out.println("before="+joinPoint.getTarget().getClass());
//		连接点的参数
		joinPoint.getArgs();
		System.out.println("beginTransaction");
	}
	public void commit(JoinPoint joinPoint, Object val){
		System.out.println("after="+joinPoint.getTarget().getClass());
		System.out.println(val);
		System.out.println("commit");
	}
	public void throwingMethod(Throwable ex){
		System.out.println(ex);
	}
	public void finallyMethod(){
		System.out.println("finallyMethod");
	}
	public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		joinPoint.proceed();//执行目标方法
	}
}
