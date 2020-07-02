package com.multiDataSourceSpring.service;

import com.multiDataSourceSpring.dto.DataSourceDto;

import java.sql.SQLException;

public interface DataSourceService {

    DataSourceDto save(DataSourceDto dataSourceDto);

    void testConnection(int dataSourceId) throws Exception;
}
