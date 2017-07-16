package cn.jd.spring.aop.privilege.action;

import cn.jd.spring.aop.privilege.service.PersonService;

public class PersonAction {
	private PersonService service;

	public void setPersonService(PersonService personService) {
		this.service = personService;
	}
	public void savePerson(){
		this.service.savePerson();
	}
}
