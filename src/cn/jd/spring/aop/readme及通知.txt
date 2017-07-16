原理：
   1、当启动spring容器
   2、spring容器会为
   		<bean id="personDao" class="com.itheima08.spring.aop.xml.PersonDaoImpl"></bean>
     	<bean id="transaction" class="com.itheima08.spring.aop.xml.Transaction"></bean>
     	这两个bean实例化对象
   3、当spring容器解析到aop:config的时候，会解析切入点表达式
 **4、spring容器把解析出来的"切入点表达式"和spring容器内部的"对象"做匹配
      	如果按照类型匹配成功，则会为该类创建代理对象，代理对象的方法体=目标方法+通知
      	如果按照类型匹配不成功,将会报错
   5、在客户端利用context.getBean获取对象时，如果有代理对象，则返回代理对象，如果没有代理对象，则返回该对象的本身

元素:
   1、目标接口
   2、目标类
   3、事务
   4、进行aop的配置
步骤：
   1、准备接口
        PersonDao
   2、准备目标类
        PersonDaoImpl
   3、准备事务
        Transaction
   4、在spring的配置文件中
   		1、引入命名空间
   			xmlns:aop="http://www.springframework.org/schema/aop"
   			http://www.springframework.org/schema/aop 
           http://www.springframework.org/schema/aop/spring-aop-2.5.xsd
        2、把personDao和事务放入到spring容器中
        	<bean id="personDao" class="com.itheima08.spring.aop.xml.PersonDaoImpl">
        	</bean>
     		<bean id="transaction" class="com.itheima08.spring.aop.xml.Transaction">
     		</bean>
     	3、aop的配置
     		<aop:config>
	     	<!-- 
	     		切入点表达式
	     			expression
	     		   id是唯一标示
	     	 -->
	     	<aop:pointcut 
	     		expression="execution(* com.itheima08.spring.aop.xml.PersonDaoImpl.*(..))" 
	     		id="perform"/>
	     	<!-- 
	     		aop:aspect就代表一个切面
	     	 -->
	     	<aop:aspect ref="transaction">
	     		<!-- 
	     			前置通知
	     		 -->
	     		<aop:before method="beginTransaction" pointcut-ref="perform"/>
	     		<!-- 
	     			后置通知
	     		 -->
	     		<aop:after-returning method="commit" pointcut-ref="perform"/>
	     	</aop:aspect>
	     </aop:config>
	   4、客户端
	   		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			PersonDao personDao = (PersonDao)context.getBean("personDao");
			personDao.savePerson();
		personDao就是代理对象，savePerson方法=目标方法+通知
1、前置通知
	1、在目标方法执行之前
	       开启事务
	       开启日志
	       引入安全性的框架
	       
	       统计dao层所有的类的所有的方法被调用了多少次？
	2、获取连接点的信息
2、后置通知
    1、如果目标方法抛出异常，将不再执行
    2、能够获取目标方法的返回值
    3、如果和前置通知结合在一起，可以在目标方法的上下文加一些代码，但是没有办法控制目标方法的执行
3、异常通知
	获取目标方法抛出的异常
4、最终通知
         相当于finally
5、环绕通知
	控制目标方法的执行

