package com.multiDataSourceSpring.util;

import com.multiDataSourceSpring.entity.DataSource;
import com.multiDataSourceSpring.entity.enums.DBSMName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class DataSourceFactory {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);

    private static Map<DBSMName, String> driverClassNameMap = new HashMap<>();
    private static Map<DBSMName, String> protocolMap = new HashMap<>();

    private static DriverManagerDataSource driverDataSource;

    @PostConstruct
    public void init() {
        driverClassNameMap.put(DBSMName.MYSQL, "com.mysql.cj.jdbc.Driver");
        driverClassNameMap.put(DBSMName.POSTGRESQL, "org.postgresql.Driver");
        driverClassNameMap.put(DBSMName.ORACLE, "oracle.jdbc.driver.OracleDriver");
        logger.info("driverClassNameMap updated: {}", driverClassNameMap.toString());

        protocolMap.put(DBSMName.MYSQL, "jdbc:mysql:");
        protocolMap.put(DBSMName.POSTGRESQL, "jdbc:postgresql:");
        protocolMap.put(DBSMName.ORACLE, "jdbc:oracle:thin:@");
        logger.info("protocolMap updated: {}", protocolMap.toString());
    }

    public static DriverManagerDataSource getDriverDataSource(DataSource dataSource) throws SQLException {
        if (driverDataSource == null) {
            driverDataSource = new DriverManagerDataSource();
            driverDataSource.setDriverClassName(driverClassNameMap.get(dataSource.getDataSourceType().getName()));

            String url = new StringBuilder().append(protocolMap.get(dataSource.getDataSourceType().getName())).append("//").append(dataSource.getHost()).append(":")
                    .append(dataSource.getPort()).append("/").append(dataSource.getDatabaseName()).toString();
            driverDataSource.setUrl(url);

            driverDataSource.setUsername(dataSource.getUserName());
            driverDataSource.setPassword(dataSource.getPassword());

            if (dataSource.getAdditionalProperties() != null && !dataSource.getAdditionalProperties().isEmpty()) {
                Properties properties = getProperties(dataSource.getAdditionalProperties());
                driverDataSource.setConnectionProperties(properties);
            }
        }
        return driverDataSource;
    }

    private static Driver getDriver(String jdbcUrl) throws SQLException {
        return DriverManager.getDriver(jdbcUrl);
    }

    private static Properties getProperties(Map<String, String> storedProperties) {
        Properties properties = new Properties();
        for (String key : storedProperties.keySet()) {
            properties.setProperty(key, storedProperties.get(key));
        }
        return properties;
    }

    public static void clearDataSource() {
        if (driverDataSource != null) {
            driverDataSource = null;
        }
    }
}
