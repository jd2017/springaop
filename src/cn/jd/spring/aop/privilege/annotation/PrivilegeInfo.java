package cn.jd.spring.aop.privilege.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author jd
 * @date 2017-7-3下午11:08:55
 * 权限注解
 */
@Target(ElementType.METHOD)//标记位置
@Retention(RetentionPolicy.RUNTIME)//作用域
public @interface PrivilegeInfo {
		String name() default "";
}

