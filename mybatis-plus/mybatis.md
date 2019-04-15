[toc]

## mybatis的一些语法
### 标签熟悉的信息
#### select标签
```
<select
　　<!-- 
　　　　1. id（必须配置）
　　　　id是命名空间中的唯一标识符，可被用来代表这条语句
　　　　一个命名空间（namespace）对应一个dao接口
　　　　这个id也应该对应dao里面的某个方法（sql相当于方法的实现），因此id应该与方法名一致
　　 -->
　　id="selectUser"

　　<!-- 
　　　　2. parapeterType（可选配置，默认由mybatis自动选择处理）
　　　　将要传入语句的参数的完全限定名或别名，如果不配置，mybatis会通过ParamterHandler根据参数类型默认选择合适的typeHandler进行处理
　　　　paramterType 主要指定参数类型，可以是int, short, long, string等类型，也可以是复杂类型（如对象）
　　 -->
　　parapeterType="int"

　　<!-- 
　　　　3. resultType（resultType 与 resultMap 二选一配置）
　　　　用来指定返回类型，指定的类型可以是基本类型，也可以是java容器，也可以是javabean
　　 -->
　　resultType="hashmap"
　　
　　<!-- 
　　　　4. resultMap（resultType 与 resultMap 二选一配置）
　　　　用于引用我们通过 resultMap 标签定义的映射类型，这也是mybatis组件高级复杂映射的关键
　　 -->
　　resultMap="USER_RESULT_MAP"
　　
　　<!-- 
　　　　5. flushCache（可选配置）
　　　　将其设置为true，任何时候语句被调用，都会导致本地缓存和二级缓存被清空，默认值：false
　　 -->
　　flushCache="false"

　　<!-- 
　　　　6. useCache（可选配置）
　　　　将其设置为true，会导致本条语句的结果被二级缓存，默认值：对select元素为true
　　 -->
　　useCache="true"

　　<!-- 
　　　　7. timeout（可选配置）
　　　　这个设置是在抛出异常之前，驱动程序等待数据库返回请求结果的秒数，默认值为：unset（依赖驱动）
　　 -->
　　timeout="10000"

　　<!-- 
　　　　8. fetchSize（可选配置）
　　　　这是尝试影响驱动程序每次批量返回的结果行数和这个设置值相等。默认值为：unset（依赖驱动）
　　 -->
　　fetchSize="256"

　　<!-- 
　　　　9. statementType（可选配置）
　　　　STATEMENT, PREPARED或CALLABLE的一种，这会让MyBatis使用选择Statement, PrearedStatement或CallableStatement，默认值：PREPARED
　　 -->
　　statementType="PREPARED"

　　<!-- 
　　　　10. resultSetType（可选配置）
　　　　FORWARD_ONLY，SCROLL_SENSITIVE 或 SCROLL_INSENSITIVE 中的一个，默认值为：unset（依赖驱动）
　　 -->
　　resultSetType="FORWORD_ONLY"
></select>
```

#### resultMap 标签的属性信息
```<!-- 
   　　1. type 对应的返回类型，可以是javabean, 也可以是其它
   　　2. id 必须唯一， 用于标示这个resultMap的唯一性，在使用resultMap的时候，就是通过id引用
   　　3. extends 继承其他resultMap标签
    -->
   <resultMap type="" id="" extends="">　　
   　　<!-- 
   　　　　1. id 唯一性，注意啦，这个id用于标示这个javabean对象的唯一性， 不一定会是数据库的主键（不要把它理解为数据库对应表的主键）
   　　　　2. property 属性对应javabean的属性名
   　　　　3. column 对应数据库表的列名
          （这样，当javabean的属性与数据库对应表的列名不一致的时候，就能通过指定这个保持正常映射了）
   　　 -->
   　　<id property="" column=""/>
           
   　　<!-- 
   　　　　result 与id相比，对应普通属性
   　　 -->    
   　　<result property="" column=""/>
           
   　　<!-- 
   　　　　constructor 对应javabean中的构造方法
   　　 -->
   　　<constructor>
   　　　　<!-- idArg 对应构造方法中的id参数 -->
          <idArg column=""/>
          <!-- arg 对应构造方法中的普通参数 -->
          <arg column=""/>
      </constructor>
      
      <!-- 
   　　　　collection 为关联关系，是实现一对多的关键 
   　　　　1. property 为javabean中容器对应字段名
   　　　　2. ofType 指定集合中元素的对象类型
   　　　　3. select 使用另一个查询封装的结果
   　　　　4. column 为数据库中的列名，与select配合使用
       -->
   　　<collection property="" column="" ofType="" select="">
   　　　　<!-- 
   　　　　　　当使用select属性时，无需下面的配置
   　　　　 -->
   　　　　<id property="" column=""/>
   　　　　<result property="" column=""/>
   　　</collection>
           
   　　<!-- 
   　　　　association 为关联关系，是实现一对一的关键
   　　　　1. property 为javabean中容器对应字段名
   　　　　2. javaType 指定关联的类型，当使用select属性时，无需指定关联的类型
   　　　　3. select 使用另一个select查询封装的结果
   　　　　4. column 为数据库中的列名，与select配合使用
   　　 -->
   　　<association property="" column="" javaType="" select="">
   　　　　<!-- 
   　　　　　　使用select属性时，无需下面的配置
   　　　　 -->
   　　　　<id property="" column=""/>
   　　　　<result property="" column=""/>
   　　</association>
   </resultMap>
   ```
#### insert 标签的属性信息
```
<insert
　　<!--
　　　　同 select 标签
　　 -->
　　id="insertProject"

　　<!-- 
　　　　同 select 标签
　　 -->
　　paramterType="projectInfo"
　　
　　<!-- 
　　　　1. useGeneratedKeys（可选配置，与 keyProperty 相配合）
　　　　设置为true，并将 keyProperty 属性设为数据库主键对应的实体对象的属性名称
　　 --> 
　　useGeneratedKeys="true"

　　<!-- 
　　　　2. keyProperty（可选配置，与 useGeneratedKeys 相配合）
　　　　用于获取数据库自动生成的主键
　　 -->
　　keyProperty="projectId"
>
```

#### 
### 一些技巧
#### 关于@param
1. 如果传入的参数只有一个，基本上不用@Param这个注解了，因为只有一个参数MyBatis就不需要区分了，不像多个参数要区分谁是谁，所以正常用

2. 多个的话要不然用序号123来表示，但是不利于维护，mybatis就提供了@Param这个注解来完成命名传入参数，这样mybatis才能通过参数名字将数

#### include
有时候选一些字段出来，我们要不然用*来表示全部，但是有时候我们只需要某一些字段来提高性能，我们避免每次都要写同样的字段，所以就用include来表示