package cn.jd.spring.aop.annotation;

import org.springframework.stereotype.Repository;

@Repository(value="personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public String save() {
		System.out.println("savePerson");
		return "val";
	}

}
