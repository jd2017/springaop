步骤：
   1、建立dao层和service层的包、接口、类
   2、建立action层的包、类
   3、建立一个权限类
         Privilege
            name  用来指定权限的名称
   4、写一个自定义的注解
        @PrivilegeInfo
   5、写一个注解解析器
                     为了解析service层的所有的类的所有的方法上的注解
   6、切面
          	环绕通知
          	       获取用户的权限
          	       获取访问目标方法应该具有的权限
   7、spring的配置文件
   		1、把action,service,dao层所有的类放入到spring容器中
   		2、把切面放入到spring容器中
   		3、进行aop的配置