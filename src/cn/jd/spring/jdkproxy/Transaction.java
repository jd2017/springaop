package cn.jd.spring.jdkproxy;

public class Transaction {
	public void beginTransation(){
		System.out.println("beginTransation");
	}
	public void commit(){
		System.out.println("commit");
	}
}
