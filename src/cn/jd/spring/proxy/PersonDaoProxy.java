package cn.jd.spring.proxy;

public class PersonDaoProxy {
	private Transaction trans;
	private PersonDao dao;
	public PersonDaoProxy(Transaction trans, PersonDao dao) {
		this.trans = trans;
		this.dao = dao;
	}
	public void savePerson(){
		/**
		 * 1,开启事务
		 * 2，save操作
		 * 3，提交事务
		 */
		this.trans.beginTransation();
		this.dao.save();
		this.trans.commit();
		
	}
	

}
