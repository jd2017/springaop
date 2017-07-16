package cn.jd.spring.aop.privilege.annotation;

import java.lang.reflect.Method;

public class AnnotationParse {
	/**
	 * 
	 * @param targetClass		//目标类 class形式
	 * @param methodName		//目标方法
	 * @return
	 */
	public static String parse(Class targetClass,String methodName) throws Exception, NoSuchMethodException{
		
		Method method = targetClass.getMethod(methodName);
		String privilageName = "";
		if(method ==null)
				throw new Exception("方法不存在");
		//请求的目标方法上面是否存在该注解；
		if(method.isAnnotationPresent(PrivilegeInfo.class)){
			PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
			privilageName = privilegeInfo.name();
		}
		return privilageName;
	}
}
