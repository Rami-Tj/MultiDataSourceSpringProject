package com.multiDataSourceSpring.controller;

import com.multiDataSourceSpring.service.DataSourceService;
import com.multiDataSourceSpring.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "test")
public class TestController {

    private final DataSourceService dataSourceService;

    public TestController(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    @RequestMapping(value = "/secondConnection", method = RequestMethod.POST)
    public void testSecondConnection() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String query = "select u.* from users u";

        List result = session.createNativeQuery(query).getResultList();
        System.out.println(result.toString());

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }

    @RequestMapping(value = "/testConnection/{dataSourceId}", method = RequestMethod.GET)
    public void testConnection(@PathVariable int dataSourceId) throws Exception {
        dataSourceService.testConnection(dataSourceId);
    }

}
