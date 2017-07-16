package cn.jd.spring.aop.privilege.service.impl;

import cn.jd.spring.aop.privilege.annotation.PrivilegeInfo;
import cn.jd.spring.aop.privilege.dao.PersonDao;
import cn.jd.spring.aop.privilege.service.PersonService;

public class PersonServiceImpl implements PersonService {
	private PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	@PrivilegeInfo(name="savePerson")
	public void savePerson() {
		this.personDao.savePerson();
	}

}
