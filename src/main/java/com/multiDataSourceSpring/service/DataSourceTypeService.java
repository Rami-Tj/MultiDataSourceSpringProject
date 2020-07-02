package com.multiDataSourceSpring.service;

import com.multiDataSourceSpring.entity.DataSourceType;
import com.multiDataSourceSpring.entity.enums.DBSMName;

public interface DataSourceTypeService {

    DataSourceType createTypeIfNotFound(DBSMName name);
}
