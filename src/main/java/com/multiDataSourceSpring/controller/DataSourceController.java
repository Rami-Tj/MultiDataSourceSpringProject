package com.multiDataSourceSpring.controller;

import com.multiDataSourceSpring.dto.DataSourceDto;
import com.multiDataSourceSpring.service.DataSourceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "dataSource")
public class DataSourceController {

    private final DataSourceService dataSourceService;

    public DataSourceController(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public DataSourceDto save(@RequestBody DataSourceDto dataSourceDto) {
        return dataSourceService.save(dataSourceDto);
    }
}
