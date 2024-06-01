# zliss-mybatis-generator

[![](https://jitpack.io/v/zliss/zliss-mybatis-generator.svg)](https://jitpack.io/#zliss/zliss-mybatis-generator)

## Get it

### Jitpack

Maven
* Step1
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

* Step2
```xml
<dependency>
    <groupId>com.github.zliss.zliss-mybatis-generator</groupId>
    <artifactId>zliss-mybatis-generator</artifactId>
    <version>0.0.1</version>
</dependency>
```

Gradle
* Step1
```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```
* Step2
```groovy
dependencies {
    compile 'com.github.zliss.zliss-mybatis-generator:zliss-mybatis-generator:0.0.1'
}
```

### Github

Maven
* Step1
```xml
<repository>
    <id>zliss-maven-repository</id>
    <url>https://raw.githubusercontent.com/zliss/zliss-maven-repository/mvn-repo</url>
</repository>
```

* Step2
```xml
<dependency>
    <groupId>net.zliss</groupId>
    <artifactId>zliss-mybatis-generator</artifactId>
    <version>0.0.1</version>
</dependency>
```

Gradle
* Step1
```groovy
repositories {
    maven {
        url "https://raw.githubusercontent.com/zliss/zliss-maven-repository/mvn-repo"
    }
}
```
* Step2
```groovy
dependencies {
    compile 'net.zliss:zliss-mybatis-generator:0.0.1'
}
```

# Examples

## code generator

### generator class

```java

public class ZGeneratorExample {
    public static void main(String[] args) {

        /**
         *
         * CREATE TABLE `z_item` (
         * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
         * `type` varchar(32) NOT NULL DEFAULT '' COMMENT 'type',
         * `url` varchar(32) NOT NULL DEFAULT '' COMMENT 'url',
         * `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'status',
         * PRIMARY KEY (`id`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='z_item';
         *
         * CREATE TABLE `z_item_t` (
         * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
         * `type` varchar(32) NOT NULL DEFAULT '' COMMENT 'type',
         * `url` varchar(32) NOT NULL DEFAULT '' COMMENT 'url',
         * `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'status',
         * PRIMARY KEY (`id`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='z_item_t';
         *
         * CREATE TABLE `z_user` (
         * `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
         * `phone` varchar(32) NOT NULL DEFAULT '' COMMENT 'phone',
         * `name` varchar(32) NOT NULL DEFAULT '' COMMENT 'name',
         * `img` varchar(32) NOT NULL DEFAULT '' COMMENT 'img',
         * `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT 'status',
         * PRIMARY KEY (`id`),
         * KEY `idx_phone` (`phone`)
         * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='z_user';
         *
         */

        // simple case
        ZGenerator generator1 = new ZGenerator(
                "jdbc:mysql://mysqlhost.com:3306/ztest",
                "root",
                "123456",
                "z_item_t,z_user",
                Paths.get("").toAbsolutePath()
                        + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main".replace("/", File.separator),
                "com.example.zgenerator.test.project");

        boolean r1 = generator1.build();

        if (!r1) {
            for (ZGException exception : generator1.getExceptionList()) {
                exception.getSourceException().printStackTrace();
            }
        }

        ZGSetting setting1 = ZGMiscUtil.buildZGSetting(
                "jdbc:mysql://mysqlhost.com:3306/ztest",
                "root",
                "123456",
                "z_item");

        // custom path
        setting1.setEntityDirPathFull(Paths.get("").toAbsolutePath()
                + ("/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/java/" +
                "com/example/zgenerator/test/project/entity/sub").replace("/", File.separator));
        setting1.setEntityPkgFull("com.example.zgenerator.test.project.entity.sub");
        setting1.setRepositoryDirPathFull(Paths.get("").toAbsolutePath()
                + ("/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/java/" +
                "com/example/zgenerator/test/project/repository/sub").replace("/", File.separator));
        setting1.setRepositoryPkgFull("com.example.zgenerator.test.project.repository.sub");
        setting1.setMapperDirPathFull(Paths.get("").toAbsolutePath()
                + ("/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mapper/sub").replace("/", File.separator));

        // custom remark
        setting1.setRemarkFormat("// DatabaseType:{{type}}, DatabaseDefault:{{default}}, DatabaseRemark:{{remark}}");

        // custom methods
        List<String> methodList = new ArrayList<>();
        methodList.add(ZGMethods.INSERT.getName());
        methodList.add(ZGMethods.SELECT_PAGE.getName());
        setting1.setMethodStrList(methodList);

        // custom jdbcTypeMap
        Map<Integer, JdbcJavaType> jdbcJavaTypeMap = new HashMap<>();
        /**
         * {@link java.sql.Types}
         * {@link net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaTypes}
         * {@link net.zliss.tool.mybatis.generator.zgenerator.model.ZGFieldTypeModel.JdbcJavaType}
         */
        jdbcJavaTypeMap.put(Types.TINYINT, JdbcJavaTypes.INTEGER);
        // jdbcJavaTypeMap.put(Types.TINYINT, new JdbcJavaType("MyInteger", "my.pkg"));
        setting1.setJdbcJavaTypeMap(jdbcJavaTypeMap);

        // custom vm template
        setting1.setEntityTemplatePath(Paths.get("").toAbsolutePath()
                + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mybatis/entity.vm".replace("/", File.separator));
        setting1.setRepositoryTemplatePath(Paths.get("").toAbsolutePath()
                + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mybatis/repository.vm".replace("/", File.separator));
        setting1.setMapperTemplatePath(Paths.get("").toAbsolutePath()
                + "/zliss-mybatis-generator-project/zliss-mybatis-generator-example/src/main/resources/mybatis/mapper.vm".replace("/", File.separator));
        ZGenerator generator2 = new ZGenerator(setting1);

        boolean r2 = generator2.build();

        if (!r2) {
            for (ZGException exception : generator2.getExceptionList()) {
                exception.getSourceException().printStackTrace();
            }
        }
    }
}

```

### spring mybatis class

```java
public class SpringMybatisExample {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ZUserRepository zUserRepository = ac.getBean(ZUserRepository.class);
        ZUser zUser = new ZUser();
        zUser.setName("test");
        zUserRepository.insert(zUser);
        List<ZUser> zUserList = zUserRepository.selectPage(new ZUser(), new PageRequest(0, 10));

        ZItemTRepository zItemTRepository = ac.getBean(ZItemTRepository.class);
        ZItemT zItemT = new ZItemT();
        zItemT.setType("test");
        zItemTRepository.insert(zItemT);
        List<ZItemT> zItemTList = zItemTRepository.selectPage(new ZItemT(), new PageRequest(0, 10));

        ZItemRepository zItemRepository = ac.getBean(ZItemRepository.class);
        ZItem zItem = new ZItem();
        zItem.setType("test");
        zItemRepository.insert(zItem);
        List<ZItem> zItemList = zItemRepository.selectPage(new ZItem(), new PageRequest(0, 10));
    }
}

```



## maven plugin

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>zliss-tool</artifactId>
        <groupId>net.zliss</groupId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../../pom.xml</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>zliss-mybatis-generator-example-maven</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>net.zliss</groupId>
                <artifactId>zliss-mybatis-generator-maven</artifactId>
                <version>0.0.1</version>
                <configuration>
                    <url>jdbc:mysql://mysqlhost.com:3306/ztest?connectTimeout=5000</url>
                    <user>root</user>
                    <password>123456</password>
                    <tables>z_user,z_item</tables>
                    <!-- mac -->
                    <projectPath>${basedir}/src/main</projectPath>
                    <parentPkg>com.example.zgenerator.test.project</parentPkg>
                    <!-- custom setting -->
<!--                    <entityDirPathFull>${basedir}/src/main/java/com/example/zgenerator/test/project/entity</entityDirPathFull>-->
<!--                    <entityPkgFull>com.example.zgenerator.test.project.entity</entityPkgFull>-->
<!--                    <repositoryDirPathFull>${basedir}/src/main/java/com/example/zgenerator/test/project/repository</repositoryDirPathFull>-->
<!--                    <repositoryPkgFull>com.example.zgenerator.test.project.repository</repositoryPkgFull>-->
<!--                    <mapperDirPathFull>${basedir}/src/main/resources/mapper</mapperDirPathFull>-->
<!--                    <remarkFormat>// DatabaseType:{{type}}, DatabaseDefault:{{default}}, DatabaseRemark:{{remark}}</remarkFormat>-->
<!--                    <entityTemplatePath>${basedir}/src/main/resources/mybatis/entity.vm</entityTemplatePath>-->
<!--                    <repositoryTemplatePath>${basedir}/src/main/resources/mybatis/repository.vm</repositoryTemplatePath>-->
<!--                    <mapperTemplatePath>${basedir}/src/main/resources/mybatis/mapper.vm</mapperTemplatePath>-->

                    <!-- windows -->
<!--                    <projectPath>${basedir}\src\main</projectPath>-->

<!--                    <methods>insert,updateByPrimaryKey,selectCount,selectPage</methods>-->
<!--                    <jdbcJavaTypeMapJson>{-6:{"type":"Integer"}}</jdbcJavaTypeMapJson>-->
                </configuration>
            </plugin>
        </plugins>
    </build>

    <pluginRepositories>
        <pluginRepository>
            <id>zliss-maven-repository</id>
            <url>https://raw.githubusercontent.com/zliss/zliss-maven-repository/mvn-repo</url>
        </pluginRepository>
    </pluginRepositories>
</project>

```
























