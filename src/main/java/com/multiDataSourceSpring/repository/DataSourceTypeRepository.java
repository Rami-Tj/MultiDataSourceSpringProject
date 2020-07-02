package com.multiDataSourceSpring.repository;

import com.multiDataSourceSpring.entity.DataSourceType;
import com.multiDataSourceSpring.entity.enums.DBSMName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceTypeRepository extends JpaRepository<DataSourceType, Long> {

    DataSourceType findByName(DBSMName name);
}
