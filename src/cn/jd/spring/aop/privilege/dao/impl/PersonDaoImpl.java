package cn.jd.spring.aop.privilege.dao.impl;

import cn.jd.spring.aop.privilege.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {
	public void savePerson() {
		System.out.println("savePerson");
	}

}
