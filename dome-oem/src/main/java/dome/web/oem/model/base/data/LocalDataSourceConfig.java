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
//@Configuration
//@MapperScan(basePackages = "dome.web.oem.mapperLocal",sqlSessionFactoryRef = "localSqlSessionFactory")
//public class LocalDataSourceConfig {
//    @Primary
//    @Bean(name = "localDataSource")
//    @ConfigurationProperties("spring.datasource.local")
//    public DataSource masterDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "localSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("localDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/local/*.xml"));
//        return sessionFactoryBean.getObject();
//    }
//}
