package com.multiDataSourceSpring.service.Impl;

import com.multiDataSourceSpring.dto.DataSourceDto;
import com.multiDataSourceSpring.entity.DataSource;
import com.multiDataSourceSpring.repository.DataSourceRepository;
import com.multiDataSourceSpring.service.DataSourceService;
import com.multiDataSourceSpring.util.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceServiceImpl.class);

    private final DataSourceRepository dataSourceRepository;

    public DataSourceServiceImpl(DataSourceRepository dataSourceRepository) {
        this.dataSourceRepository = dataSourceRepository;
    }

    @Override
    @Transactional
    public DataSourceDto save(DataSourceDto dataSourceDto) {
        return new DataSourceDto(dataSourceRepository.save(dataSourceDto.convert()));
    }

    @Override
    public void testConnection(int dataSourceId) throws Exception {
        DataSourceFactory.clearDataSource();
        DataSource dataSource = dataSourceRepository.findById(dataSourceId);

        if (dataSource != null) {
            Connection connection = DataSourceFactory.getDriverDataSource(dataSource).getConnection();
            Statement statement = connection.createStatement();

            String query = "select u.USER_ID, u.FIRSTNAME, u.LASTNAME, u.EMAIL from users u";

            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData resultMeta = result.getMetaData();

            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            }
            System.out.println("\n**********************************");

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    String value = result.getObject(i) != null ? result.getObject(i).toString() : "null";
                    System.out.print("\t" + value + "\t |");
                }
                System.out.println("\n---------------------------------");
            }
            result.close();
            statement.close();
        }
    }
}
