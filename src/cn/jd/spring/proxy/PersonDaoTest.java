package cn.jd.spring.proxy;

import org.junit.Test;

/**
 * @author jd
 * @date 2017-6-26下午11:43:10
 * 静态代理
 */
public class PersonDaoTest {
	@Test
	public void test(){
		PersonDao dao = new PersonDaoImpl();
		Transaction trans = new Transaction();
		PersonDaoProxy proxy = new PersonDaoProxy(trans, dao);
		proxy.savePerson();
	}
}
