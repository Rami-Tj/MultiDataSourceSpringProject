package com.multiDataSourceSpring.dto;

import com.multiDataSourceSpring.entity.DataSource;
import com.multiDataSourceSpring.entity.DataSourceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class DataSourceDto implements Serializable {
    private int id;
    private String name;
    private DataSourceTypeDto dataSourceType;
    private String host;
    private int port;
    private String databaseName;
    private String userName;
    private String password;
    private Map<String, String> additionalProperties;

    public DataSourceDto(DataSource dataSource) {
        this.id = dataSource.getId();
        this.name = dataSource.getName();
        if (dataSource.getDataSourceType() != null) {
            this.dataSourceType = new DataSourceTypeDto(dataSource.getDataSourceType());
        }
        this.host = dataSource.getHost();
        this.port = dataSource.getPort();
        this.databaseName = dataSource.getDatabaseName();
        this.userName = dataSource.getUserName();
        this.password = dataSource.getPassword();
        if (dataSource.getAdditionalProperties() != null && !dataSource.getAdditionalProperties().isEmpty()) {
            this.additionalProperties = dataSource.getAdditionalProperties();
        }
    }

    public DataSource convert() {
        DataSource dataSource = new DataSource();
        dataSource.setId(this.id);
        dataSource.setName(this.name);
        if (this.dataSourceType != null) {
            dataSource.setDataSourceType(this.dataSourceType.convert());
        }
        dataSource.setHost(this.host);
        dataSource.setPort(this.port);
        dataSource.setDatabaseName(this.databaseName);
        dataSource.setUserName(this.userName);
        dataSource.setPassword(this.password);
        if (this.additionalProperties != null && !this.additionalProperties.isEmpty()) {
            dataSource.setAdditionalProperties(this.additionalProperties);
        }
        return dataSource;
    }
}
