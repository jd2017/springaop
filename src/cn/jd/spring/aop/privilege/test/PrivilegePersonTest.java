package cn.jd.spring.aop.privilege.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jd.spring.aop.privilege.Privilege;
import cn.jd.spring.aop.privilege.action.PersonAction;
import cn.jd.spring.aop.privilege.aspect.PrivilegeAspect;
import cn.jd.spring.aop.privilege.dao.PersonDao;

public class PrivilegePersonTest {
	@Test
	public void test(){
		ApplicationContext context =new  ClassPathXmlApplicationContext("applicationContext.xml");
//		PersonAction personAction = (PersonAction) context.getBean("personAction");	
//		personAction.savePerson();
		PrivilegeAspect privilegeAspect = (PrivilegeAspect)context.getBean("performAspect");
		
		Privilege privilege = new Privilege();
		privilege.setName("savePerson");
		List<Privilege> privileges = new ArrayList<Privilege>();
		privileges.add(privilege);
		privilegeAspect.setPrivileges(privileges);
		
		
		PersonAction action = (PersonAction)context.getBean("personAction");
		action.savePerson();
	}
}
