package com.bar3.domain.annonation;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;

public class JPADemo {
	/*
	 *  注解分为两个部分,分别是逻辑映射注解和物理映射注解, 通过逻辑映射注解可以描述对象模型,类之间的关系等等, 而物理映射注解则描述了物理的schema,表,列,索引等等. 
	 *  下面我们在代码中将混合使用这两种类型的注解
	 *  
	 *  在对一个类进行注解时,你可以选择对它的的属性或者方法进行注解,根据你的选择,Hibernate的访问类型分别为 field或property. EJ3规范要求在需要访问的元素上进行注解声明,
	 *  例如,如果访问类型为 property就要在getter方法上进行注解声明, 如果访问类型为 field就要在字段上进行注解声明.应该尽量避免混合使用这两种访问类型.
	 *  
	 *  Hibernate和EJB3都支持所有基本类型的属性映射. 这些基本类型包括所有的Java基本类型,及其各自的wrapper类和serializable类. Hibernate Annotations还支持将内置的枚举类型映射到一个顺序列(保存了相应的序列值) 
	 *  或一个字符串类型的列(保存相应的字符串).默认是保存枚举的序列值, 但是你可以通过@Enumerated注解来进行调整(见上面例子中的note属性)
	 *  
	 *  @Entity注解将一个类声明为一个实体bean(即一个持久化POJO类)
	 *  
	 *  @Id注解则声明了该实体bean的标识属性.该属性的值可以通过应用自身进行设置,也可以通过Hiberante生成(推荐).使用 @GeneratedValue注解可以定义该标识符的生成策略: 
	 *   @GeneratedValue有两个属性，strategy和genarator属性，strategy属性指定生成策略默认为GenerationType.AUTO,由hibernate根据底层数据库特性自动选择。
	 *   strategy还可以是GenerationType.IDENTITY(自增长，这种方式依赖于具体的数据，库，如果数据库不支持自增主键，那么这个类型是没法用的     )
                          ，GenerationType.SEQUENCE（序列）,GenerationType.TABLE（表格式）.使用后两种需要指定对应的
	 *   生成器，@TableGenerator,@SequenceGenerator。 每一个identifier生成器都有自己的适用范围,可以是应用级(application level)和类一级(class level). 
	 *   类一级的生成器在外部是不可见的, 而且类一级的生成器可以覆盖应用级的生成器. 应用级的生成器则定义在包一级(package level)
	 *  
	 *  定义组合主键有如下方法：
	 *  将组件类注解为@Embeddable,并将组件的属性注解为@Id，
	 *  将组件的属性注解为@EmbeddedId
	 *  将类注解为@IdClass,并将该实体中所有属于主键的属性都注解为@Id 
	 *  组合主键类对应了一个实体类中的多个字段或属性, 而且主键类中用于定义主键的字段或属性和 实体类中对应的字段或属性在类型上必须一致
	 *  
	 *  @Table是类一级的注解, 通过@Table注解可以为实体bean映射指定表名(name),目录(catalog)和schema(数据库)的名字. 如果没有定义@Table,那么系统自动使用默认值：实体的短类名(不附带包名)。
	 *  可以uniqueConstraints属性结合使用@UniqueConstraint注解可以定义表的唯一约束(unique constraint) (对于绑定到单列的唯一约束,请参考@Column注解)或者利用indexs属性可以指定索引。
	 *  如：@Table(name="tbl_sky", uniqueConstraints = {@UniqueConstraint(columnNames={"month", "day"})})，注意columnNames数组中的值指的是逻辑列名.
	 *  
	 *  @Version属性实现乐观锁
	 *  
	 *  @Transient表示该属性不被持久化，实体bean中所有的非static非transient(短暂的)的属性(如private transient int sum)都可以被持久化, 除非你将其注解为@Transient. 
	 *  
	 *  @Basic表示一个简单的属性到数据库表的字段的映射,对于没有任何标注的getXxxx()方法,默认即为@Basic,该注解有两个属性：fetch: 表示该属性的读取策略,有EAGER和LAZY两种,分别表示主支抓取和延迟加载,默认为EAGER(主支抓取).
	 *  延迟获取表示Hibernate在创建一个实体Bean的实例时,不会即时将这个属性的值从数据库中读出. 只有在该实体Bean的这个属性第一次被调用时,Hibernate才会去获取对应的值. 通常你不需要对简单属性设置延迟获取(lazy simple property)
	 *  另外为了启用属性级的延迟获取,你的类必须经过特殊处理(instrumented)： 字节码将被织入原始类中来实现延迟获取功能。
	 *  optional:表示该属性是否允许为null,默认为true。如@Basic(fetch=FetchType.LAZY,optional=false)，表示指定属性延迟加载，不允许为空。所有没有定义注解的属性等价于在其上面添加了@Basic注解.
	 *  
	 *  @Enumerated表示对枚举类型的属性成员进行映射，该注解只有一个属性值EnumType，可选值为STRING和ORDINAL,分别表示将该枚举属性值的toString方法返回值或者ordinal方法返回的值映射到数据库中
	 *  
	 *  @Temporal注解表示Date类型的属性在数据库映射的字段的精度，只有一个属性TemporalType，可选值为DATE,TIME,TIMESTAMP，分别表示存储日期，时间和日期时间两者。
	 *  
	 *  @Lob注解表示属性将被持久化为Blob或者Clob类型, 具体取决于属性的类型。
	 *  
	 *  @Column注解，利用该注解可将属性映射到列，覆盖默认值。在属性级使用该注解的方式如下：不进行注解，使用默认值。和 @Basic或者@Version或者 @Lob或者@Temporal一起使用。该注解的属性如下：
	 *  name 可选,列名(默认值是属性名)
	 *  unique 可选,是否在该列上设置唯一约束(默认值false)
	 *  nullable 可选,是否设置该列的值可以为空(默认值false)
	 *  insertable 可选,该列是否作为生成的insert语句中的一个列(默认值true)
	 *  updatable 可选,该列是否作为生成的update语句中的一个列(默认值true)
	 *  columnDefinition 可选: 为这个特定列覆盖SQL DDL片段 (这可能导致无法在不同数据库间移植)。表示该字段在数据库中的实际类型.通常ORM框架可以根据属性类型自动判断数据库中
                        字段的类型,但是对于Date类型仍无法确定数据库中字段类型究竟是DATE,TIME还是TIMESTAMP.此外,String的默认映射类型为VARCHAR,如果要将String类型映射到特定数据库的BLOB或TEXT字段类型,该
                       属性非常有用. 
	 *  table 可选,定义对应的表(默认为主表)
	 *  length 可选,列长度(默认值255)
	 *  precision 可选,列十进制精度(decimal precision)(默认值0)
	 *  scale 可选,如果列十进制数值范围(decimal scale)可用,在此设置(默认值0)
	 *  
	 *  @Embeddable注解表明该该类是一个组件， 在特定的实体的关联属性上使用@Embedded和 @AttributeOverride注解可以覆盖该属性对应的嵌入式对象的列映射：如
	 *  @Embedded
        @AttributeOverrides( {
            @AttributeOverride(name="iso2", column = @Column(name="bornIso2") ),
            @AttributeOverride(name="name", column = @Column(name="bornCountryName") )
        } )
        Country bornIn;
        bornIn为Country类型的组件或者嵌入式对象，iso2或者name表示Country类中的字段属性，bornIso2表示将born属性的iso属性映射为bornIso2字段。
	 *
	 *  映射继承关系：分为三种策略，每个类一张表(Table per class)策略，每个类层次结构一张表(Single table per class hierarchy)策略和连接的子类(Joined subclasses)策略
	 *  通过@Inheritance注解来定义所选择的策略. 这个注解需要在每个类层次结构(class hierarchy) 最顶端的实体类上使用。该注解只有一个属性strategy，对应的三种策略分别是：
	 *  InheritanceType.TABLE_PER_CLASS，InheritanceType.SINGLE_TABLE,InheritanceType.JOINED
	 *  如每个类继承层次结构：
	 *  @Entity
       @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
       @DiscriminatorColumn(
       name="planetype",
       discriminatorType=DiscriminatorType.STRING
       )
       @DiscriminatorValue("Plane")
       public class Plane { ... }

      @Entity
       @DiscriminatorValue("A320")
       public class A320 extends Plane { ... }
       Plane是父类,在这个类里面将继承策略定义为 InheritanceType.SINGLE_TABLE,并通过 @DiscriminatorColumn注解定义了辨别符列(还可以定义辨别符的类型). 最后,对于继承层次结构中的每个类,@DiscriminatorValue注解指定了用来辨别该类的值. 
                  辨别符列的名字默认为 DTYPE,其默认值为实体名(在@Entity.name中定义)，其类型 为DiscriminatorType.STRING. A320是子类,如果不想使用默认的辨别符,只需要指定相应的值即可. 其他的如继承策略,辨别标志字段的类型都是自动设定的.
	 * 
	 * 
	 * 一对一关联有三种情况： 一是关联的实体都共享同样的主键, 二是其中一个实体通过外键关联到另一个实体的主键 (注意要模拟一对一关联必须在外键列上添加唯一约束). 三是通过关联表来保存两个实体之间的连接关系 (注意要模拟一对一关联必须在每一个外键上添加唯一约束).
	 * @PrimaryKeyJoinColumn表示共享主键
	 * @JoinColumn注解定义了关联实体的外键列(join column). 该注解和@Column注解有点类似, 但是多了一个名为referencedColumnName的参数. 该参数定义了所关联目标实体中的联接列. 注意,当referencedColumnName关联到非主键列的时候, 
	 * 关联的目标类必须实现Serializable, 还要注意的是所映射的属性对应单个列(否则映射无效). 没有指定referencedColumnName属性时默认关联所关联目标的主键列
	 * @Entity
       public class Customer implements Serializable {
       @OneToOne(cascade = CascadeType.ALL)
       @JoinColumn(name="passport_fk")
       public Passport getPassport() {
        ...
        }

       @Entity
       public class Passport implements Serializable {
       @OneToOne(mappedBy = "passport")
       public Customer getOwner() {
      ...
       }
	 * 一对一关联可能是双向的.在双向关联中, 有且仅有一端是作为主体(owner)端存在的：主体端负责维护联接列(即更新). 对于不需要维护这种关系的从表则通过mappedBy属性进行声明. mappedBy的值指向主体的关联属性. 在上面这个例子中,mappedBy的值为 passport. 
	 * 最后,不必也不能再在被关联端(owned side)定义联接列了，即定义referencedColumnName属性,因为已经在主体端进行了声明.
	 * 如果在主体没有声明@JoinColumn,系统自动进行处理： 在主表(owner table)中将创建联接列, 列名为：主体的关联属性名＋下划线＋被关联端的主键列名. 在上面这个例子中是passport_id, 因为Customer中关联属性名为passport, Passport的主键是id.
	 * 
	 * 
	 * @Entity
      public class Customer implements Serializable {
       @OneToOne(cascade = CascadeType.ALL)
         @JoinTable(name = "CustomerPassports",
         joinColumns = @JoinColumn(name="customer_fk"),
        inverseJoinColumns = @JoinColumn(name="passport_fk")
    )
       public Passport getPassport() {
        ...
       }

      @Entity
      public class Passport implements Serializable {
      @OneToOne(mappedBy = "passport")
       public Customer getOwner() {
       ...
      }
	 *Customer通过名为 CustomerPassports的关联表和 Passport关联; 该关联表拥有名为passport_fk的外键列,该 外键指向Passport表,该信息定义为inverseJoinColumn的属性值, 
	 *而customer_fk外键列指向Customer表, 该信息定义为 joinColumns的属性值.
	 *
	 *@ManyToOne注解有一个名为targetEntity的参数, 该参数定义了目标实体名.通常不需要定义该参数, 因为在大部分情况下默认值(表示关联关系的属性类型)就可以很好的满足要求了. 
	 *不过下面这种情况下这个参数就显得有意义了：使用接口作为返回值而不是常见的实体.
	 *
	 *你可以对 Collection ,List (指有序列表, 而不是索引列表), Map和Set这几种类型进行映射. EJB3规范定义了怎么样使用@javax.persistence.OrderBy 注解来对有序列表进行映射： 该注解接受的参数格式：
	 *用逗号隔开的(目标实体)属性名及排序指令, 如firstname asc, age desc,如果该参数为空,则默认以id对该集合进行排序. 如果某个集合在数据库中对应一个关联表(association table)的话,你不能在这个集合属性上面使用。
	 *
	 *EJB3 允许你利用目标实体的一个属性作为Map的key, 这个属性可以用@MapKey(name="myProperty")来声明. 如果使用@MapKey注解的时候不提供属性名, 系统默认使用目标实体的主键. map的key使用和属性相同的列：不需要为map key定义专用的列，
	 *因为map key实际上就表达了一个目标属性。 注意一旦加载,key不再和属性保持同步, 也就是说,如果你改变了该属性的值,在你的Java模型中的key不会自动更新
	 *
	 *当双向多对多关联中没有定义任何物理映射时, Hibernate根据以下规则生成相应的值 关联表名: :主表表名+_下划线+从表表名, 关联到主表的外键名:从表用于关联的属性名+_下划线+主表中的主键列名. 关联到从表的外键名:主表用于关联的属性名+_下划线+从表的主键列名. 以上规则对于双向一对多关联同样有效.
	 *
	 *cascade属性接受的值为CascadeType数组：
	 *CascadeType.PERSIST: 如果一个实体是受管状态, 或者当persist()函数被调用时, 触发级联创建(create)操作 
	 *CascadeType.MERGE: 如果一个实体是受管状态, 或者当merge()函数被调用时, 触发级联合并(merge)操作 
	 *CascadeType.REMOVE: 当delete()函数被调用时, 触发级联删除(remove)操作 
	 *CascadeType.REFRESH: 当refresh()函数被调用时, 触发级联更新(refresh)操作 
	 *CascadeType.ALL: 以上全部 
	 *
	 *@JoinColumns,即@JoinColumn数组, 定义了关联的组合外键(如果不使用缺省值的话). 显式指明referencedColumnNames是一个好的实践方式, 否则,Hibernate认为你使用的列顺序和主键声明的顺序一致.
	 *如：
	 *@Entity
     public class Parent implements Serializable {
    @Id
    public ParentPk id;
    public int age;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="parentCivility", referencedColumnName = "isMale"),
        @JoinColumn(name="parentLastName", referencedColumnName = "lastName"),
        @JoinColumn(name="parentFirstName", referencedColumnName = "firstName")
    })
    public Set<Child> children; //unidirectional
    ...
    }
	 *@Formula("obj_length * obj_height * obj_width")
		public long getObjectVolume()注解表示某个属性通过sql查询获取
		
	 *通过在列属性(property)上使用@Index注解, 可以在特定列上定义索引
	 *
	 */
}
