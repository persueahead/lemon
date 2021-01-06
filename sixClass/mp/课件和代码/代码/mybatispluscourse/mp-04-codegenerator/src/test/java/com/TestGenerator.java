package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestGenerator {



    @Test
    public void testCodeGenerator(){


         //创建mbg
        AutoGenerator mbg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("bjlemon");// 作者
        gc.setActiveRecord(true);//开启活动记录模式
        gc.setBaseColumnList( true);// 通用字段
        gc.setBaseResultMap(true); // 基本的映射
        gc.setIdType(IdType.AUTO);//主键自增长
        gc.setServiceName("%sService");//设置服务名字
        gc.setServiceImplName("%sServiceImpl");//服务实现类名字
        gc.setFileOverride(true);//设置覆盖现有文件
        gc.setOutputDir("F:\\learn_wp\\mybatispluscourse\\mp-04-codegenerator\\src\\main\\java");//设置输出目录
        mbg.setGlobalConfig(gc);
        //数据源配置

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");//url连接
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");//用户名
        dsc.setPassword("123456");//密码
        mbg.setDataSource(dsc);

        //包配置
        PackageConfig pcg = new PackageConfig();
        pcg.setParent("com.bjlemon.mp");
        pcg.setEntity("beans");
        pcg.setMapper("mapper");
        pcg.setController("controller");
        pcg.setService("service");
        pcg.setXml("mapper");
        mbg.setPackageInfo(pcg);


        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //下滑线转驼峰命名
        strategy.setEntityLombokModel(true); // 使用 lombok
        strategy.setRestControllerStyle(true); //restful风格的api
        strategy.setInclude("sys_employee");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("sys_" );
        mbg.setStrategy(strategy);


        mbg.execute();
    }
}
