package com.vitsed.jdbclp;

import com.vitsed.jdbclp.dao.OrganizationDao;
import com.vitsed.jdbclp.daoimpl.OrganizationDaoImpl;
import com.vitsed.jdbclp.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateClassicApp {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("orgDao");

        // Create seed data
        DaoUtils.createSeedData(dao);

        // List organizations
        List<Organization> orgs = dao.getAllOrganizations();
        DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);

        // Create a new organization record
//        Organization org = new Organization("General Electric", 1978, "98989", 1923, "Imagination at work");
//        boolean isCreated = dao.create(org);
//        DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
//        DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.createOperation);

        System.out.println("Third organization is: " + dao.getOrganization(2));

        // Cleanup
//        dao.cleanup();
//        DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.cleanupOperation);

        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
