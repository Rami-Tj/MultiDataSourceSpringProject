package com.multiDataSourceSpring.dto;

import com.multiDataSourceSpring.entity.DataSourceType;
import com.multiDataSourceSpring.entity.enums.DBSMName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DataSourceTypeDto implements Serializable {
    private int id;
    private DBSMName name;

    public DataSourceTypeDto(DataSourceType dataSourceType) {
        this.id = dataSourceType.getId();
        this.name = dataSourceType.getName();
    }

    public DataSourceType convert() {
        DataSourceType dataSourceType = new DataSourceType();
        dataSourceType.setId(this.id);
        dataSourceType.setName(this.name);
        return dataSourceType;
    }
}
