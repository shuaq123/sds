//package dome.web.oem.model.base.data;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import tk.mybatis.spring.annotation.MapperScan;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@MapperScan(basePackages = "oem.example.mapper",sqlSessionFactoryRef = "devSqlSessionFactory")
//public class DevDataSourceConfig {
//    @Primary
//    @Bean(name = "devDataSource")
//    @ConfigurationProperties("spring.datasource.dev")
//    public DataSource masterDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "devSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("devDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource((javax.sql.DataSource) dataSource);
//        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/dev/*.xml"));
//        return sessionFactoryBean.getObject();
//    }
//}
