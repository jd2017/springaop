package cn.jd.spring.cglibproxy;

//目标类
public class PersonDaoImpl{
	public void save() {
		System.out.println("savePerson");
	}

}
