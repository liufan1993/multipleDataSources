package com.liufan.mutildatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

//表示这个类为一个配置类
@Configuration
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "com.liufan.mutildatasource.dao.oracle", sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class OracleConfig {
    // 将这个对象放入Spring容器中
    @Bean(name = "oracleDataSource")
    // 读取application.yml 中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "oracleSqlSessionFactory")
    // @Qualifier表示查找Spring容器中名字为oracleDataSource的对象
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/oracle/*.xml"));
        return bean.getObject();
    }
    @Bean("oracleSqlSessionTemplate")
    public SqlSessionTemplate oraclesqlsessiontemplate(
            @Qualifier("oracleSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
