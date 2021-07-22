1. 新建student表
2. 加入maven的mybatis依赖和mysql驱动
3. 创建实体类 Student- 用来保存表中的一行数据
4. 创建持久层的dao接口 定义操作数据库的方法
5. 创建mybatis配置文件，叫做sql映射文件，用来写sql语句的。一般一个表一个sql映射文件
   - 写在Dao接口所在的目录中
   - 文件名称与接口名保持一致
6. 创建mybatis的主配置文件，主配置文件提供了数据库的连接信息和sq1映射文件的位置信息
7. 创建使用mybatis的类，通过mybatis访问数据库