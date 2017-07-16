package cn.jd.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value="transaction")
@Aspect
public class Transaction {
	
	@Pointcut("execution(* cn.jd.spring.aop.annotation.*.*(..))")
	public void idName(){}
	
	@Before("idName()")
	public void beginTransaction(JoinPoint joinPoint){
//		连接点名称
		System.out.println("连接点名称"+joinPoint.getSignature().getName());
//		连接点目标
		System.out.println("before="+joinPoint.getTarget().getClass());
//		连接点的参数
		joinPoint.getArgs();
		System.out.println("beginTransaction");
	}
}
