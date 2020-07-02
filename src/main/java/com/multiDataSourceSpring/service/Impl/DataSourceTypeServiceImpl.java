package com.multiDataSourceSpring.service.Impl;

import com.multiDataSourceSpring.entity.DataSourceType;
import com.multiDataSourceSpring.entity.enums.DBSMName;
import com.multiDataSourceSpring.repository.DataSourceTypeRepository;
import com.multiDataSourceSpring.service.DataSourceTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataSourceTypeServiceImpl implements DataSourceTypeService {

    private final DataSourceTypeRepository dataSourceTypeRepository;

    public DataSourceTypeServiceImpl(DataSourceTypeRepository dataSourceTypeRepository) {
        this.dataSourceTypeRepository = dataSourceTypeRepository;
    }

    @Override
    @Transactional
    public DataSourceType createTypeIfNotFound(DBSMName name) {
        DataSourceType dataSourceType = dataSourceTypeRepository.findByName(name);
        if (dataSourceType == null) {
            return dataSourceTypeRepository.save(new DataSourceType(name));
        }
        return null;
    }
}
