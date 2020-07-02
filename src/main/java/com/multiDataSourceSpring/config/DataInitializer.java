package com.multiDataSourceSpring.config;

import com.multiDataSourceSpring.entity.User;
import com.multiDataSourceSpring.entity.enums.DBSMName;
import com.multiDataSourceSpring.service.DataSourceTypeService;
import com.multiDataSourceSpring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private final DataSourceTypeService dataSourceTypeService;
    private final UserService userService;

    public DataInitializer(DataSourceTypeService dataSourceTypeService, UserService userService) {
        this.dataSourceTypeService = dataSourceTypeService;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (DBSMName value : DBSMName.values()) {
            dataSourceTypeService.createTypeIfNotFound(value);
        }

        for (int i = 1; i <= 250; i++) {
            Optional<User> optionalUser = userService.createUserIfNotFound(i);
            optionalUser.ifPresent(user -> logger.info("user created {}", user.toString()));
        }

    }
}
