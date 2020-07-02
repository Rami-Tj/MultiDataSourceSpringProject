package com.multiDataSourceSpring.repository;

import com.multiDataSourceSpring.entity.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
    DataSource findById(int dataSourceId);
}
