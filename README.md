# springboot-multipledatasources


multipledatasources2：
通过分包实现多数据源的，但事务上存在问题，事务管理器只能处理主数据源的事务

multipledatasources3：
通过分包扫描，定义不同的两个数据库，利用jta-atomikos解决传统(单应用)项目多数据源事务管理问题

multipledatasources4：
通过aop的方式实现动态数据库切换+jta-atomikos(手动、注解自动处理多数据源事务问题)
