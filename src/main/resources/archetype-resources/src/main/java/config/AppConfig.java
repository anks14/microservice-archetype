#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )


package ${package}.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${dataSourcePassword}")
    private String dataSourcePassword;

    @Value("${dbConnectionTestQuery}")
    private String dbConnectionTestQuery;
    @Value("${spring.datasource.username}")
    private String dataSourceUserName;

    @Value("${dbConnectionTimeout}")
    private String dbConnectionTimeout;
    @Value("${dbIdleTimeout}")
    private String dbIdleTimeout;
    @Value("${dbMaxLifetime}")
    private String dbMaxLifetime;
    @Value("${dbMinIdleTime}")
    private String dbMinIdleTime;
    @Value("${dbPoolSize}")
    private String dbPoolSize;
    @Value("${dbPoolName}")
    private String dbPoolName;


    @Bean(name = "datasource")
    public DataSource dataSource() {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(datasourceUrl);
        hikariConfig.setUsername(dataSourceUserName);
        hikariConfig.setPassword(dataSourcePassword);
        hikariConfig.setConnectionTestQuery(dbConnectionTestQuery);
        hikariConfig.setConnectionInitSql(dbConnectionTestQuery);
        hikariConfig.setConnectionTimeout(TimeUnit.SECONDS.toMillis(Long.valueOf(dbConnectionTimeout)));
        hikariConfig.setIdleTimeout(TimeUnit.HOURS.toMillis(Long.valueOf(dbIdleTimeout)));
        hikariConfig.setMaxLifetime(TimeUnit.DAYS.toMillis(Long.valueOf(dbMaxLifetime)));
        hikariConfig.setMinimumIdle(Integer.valueOf(dbMinIdleTime));
        hikariConfig.setMaximumPoolSize(Integer.valueOf(dbPoolSize));
        hikariConfig.setPoolName(dbPoolName);
        hikariConfig.addDataSourceProperty("cachePrepStmts", true);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
