package com.example.springboot_curd.common;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {



    /**
     * <p></p>
     */
    public static String packageName="com.example.springboot_curd";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置 配置类
        GlobalConfig gc = new GlobalConfig();
        //System.getProperty(user.dir) 获取的是启动项目的容器位置，用IDEA是项目的根目录，部署在tomcat上是tomcat的启动路径，即tomcat/bin的位置
        String projectPath = System.getProperty("user.dir");
        //指定输出目录
        gc.setOutputDir(projectPath + "\\src\\main\\java");
        //作者名
        gc.setAuthor("xiaojiaxin");
        //是否打开输出目录
        gc.setOpen(false);
        //时间策略
        gc.setDateType(DateType.ONLY_DATE);
        //覆盖已生成文件 默认值:false
        gc.setFileOverride(true);

        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setServiceName("%sService");//去掉service的i前缀
        gc.setIdType(IdType.ID_WORKER_STR);//设置id的生成策略默认算法
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/curd?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("curd");
        pc.setParent(packageName);
        pc.setController("controller");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/java/com/example/springboot_curd/"+ pc.getModuleName()+"/mapper/xml"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//列名规则
//        strategy.setSuperEntityClass("com.springboot.sanya.base.EntityBase");
        strategy.setEntityLombokModel(true);//是否生成lombok注解
        strategy.setCapitalMode(true);
        strategy.setEntitySerialVersionUID(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);//设置命名规则下划线转驼峰

        //strategy.setInclude("t_correct");//修改替换成你需要的表名，多个表名传数组
        //strategy.setInclude("t_metadata_info");//修改替换成你需要的表名，多个表名传数组
        strategy.setInclude("t_user");//修改替换成你需要的表名，多个表名传数组
//        strategy.setSuperControllerClass("com.example.springboot_curd.base.BaseController");

//        strategy.setSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time", "is_del");
//        strategy.setTableFillList(Arrays.asList(new TableFill("create_time", FieldFill.INSERT),
//                new TableFill("update_time", FieldFill.INSERT_UPDATE)));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);  // 是否生成实体时，生成字段注解
        strategy.setTablePrefix("t_");//数据库表 前缀去除
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }

}
