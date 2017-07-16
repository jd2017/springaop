package cn.jd.spring.aop.privilege.aspect;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.jd.spring.aop.privilege.Privilege;
import cn.jd.spring.aop.privilege.annotation.AnnotationParse;

public class PrivilegeAspect {
	private List<Privilege> privileges;
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	/**
	 	环绕通知
	 * @param joinPoint
	 * @return
	 * @throws Throwable 
	 */
	public Object privilegeControl(ProceedingJoinPoint joinPoint) throws Throwable{
		/**
		 * 1, 获取用户的访问的权限
		 * 2，获取目标方法应该具有的权限
		 * 3，判断权限是否包含？
		 */
		//方法的名称
		String methodName = joinPoint.getSignature().getName();
		//目标方法Class形式；
		Class target = joinPoint.getTarget().getClass();
		String privilegeName = AnnotationParse.parse(target, methodName);
		if("".equals(privilegeName)){
			System.out.println("目标方法上 存在该注解，属性为空");
		}
		Object obj =null;
		boolean flag = false;
		for(Privilege p : privileges){
			if(p.getName().equals(privilegeName)){
				flag = true;
				break;
			}
		}
		if(flag)
			obj = joinPoint.proceed();
		else
			System.out.println("权限不足");
		return obj;
	}
	public void throwingMethod(Throwable ex){
		System.out.println(ex.getMessage());
	}
}
