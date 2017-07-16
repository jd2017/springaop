package cn.jd.spring.proxy;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void save() {
		System.out.println("savePerson");

	}

}
