package cn.jd.spring.aop;

public class PersonDaoImpl implements PersonDao {

	@Override
	public String save() {
		int i=1/0;
		System.out.println("savePerson");
		return "val";
	}

}
