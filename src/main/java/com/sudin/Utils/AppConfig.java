//package com.sudin.Utils;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@Configuration
//public class AppConfig {
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() throws SQLException {
//        HikariConfig config = new HikariConfig("/hikari.properties");
//        HikariDataSource dataSource = new HikariDataSource(config);
//
//        return dataSource;
//    }
//
//}
