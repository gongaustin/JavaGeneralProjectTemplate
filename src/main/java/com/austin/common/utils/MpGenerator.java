package com.austin.common.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @Description: 代码自动生成工具
 * @Author: GongJun
 * @Date: Created in 12:34 2021/1/29
 */
public class MpGenerator {

    private static final String package_name = "com.austin.common";  //包名
    private static final String driver_class_name = "com.mysql.cj.jdbc.Driver";   //数据库驱动
    private static final String url = "jdbc:mysql://127.0.0.1:3306/yuechi_hospital?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&&useSSL=true";
    private static final String username = "root"; //用户名
    private static final String password = "123";  //密码

    public static void main(String args[]) {
        //表前缀
        String[] table_prefix = new String[]{"busi_", "upms_"};  //表前缀
        //处理的表名
        String[] table_names = new String[]{
                "upms_user",
                "upms_log",
                "upms_dept",
                "busi_article",
                "busi_doctor",
                "busi_attachment",
                "busi_module"
        }; 

        new MpGenerator().generateCode(package_name, table_prefix, table_names);
    }

    public void generateCode(String packageName, String[] prefix, String... tableName) {
//        boolean serviceNameStartWithI = true;//user -> IUserService, 设置成true: user -> IUserService
        generateByTables(packageName, prefix, tableName);
    }

    private void generateByTables(String packageName, String[] prefix, String... tableNames) {

        String dbUrl = url;
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
                //数据源类型
                .setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driver_class_name);
        //StrategyConfig
        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true)
                //[true]自动生成lombok注解,去除get和set方法,自动为实体添加数据库字段的注释
                .setEntityLombokModel(false)
                //生成TableField注解
                .setEntityTableFieldAnnotationEnable(true)
                .setTablePrefix(prefix)
                .setNaming(NamingStrategy.underline_to_camel)  //设置命名规则下划线转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)//列名规则
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        //设置全局配置参数
        //全局配置
        GlobalConfig config = new GlobalConfig()
                //通用查询映射
                .setBaseResultMap(true)
                //用用结果查询列,基本的sql片段
                .setBaseColumnList(false)
                //ID类型设置
                .setIdType(IdType.ASSIGN_UUID)
                //Swagger
                .setSwagger2(true)
                //AR模式
                .setActiveRecord(false)
                //缓存
                .setEnableCache(false)
                //作者
                .setAuthor("AustinGJ")
                //输出目录
                .setOutputDir("d:/tmp")
                //覆盖
                .setFileOverride(true);
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setEntity("entity")
                                .setMapper("mapper")
                                .setXml("resource.mapper")
                                .setController("controller")
                                .setService("service")
                                .setServiceImpl("service.impl")
                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(packageName, tableNames);
    }

}
