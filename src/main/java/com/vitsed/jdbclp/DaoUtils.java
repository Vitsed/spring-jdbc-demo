package com.vitsed.jdbclp;

import com.vitsed.jdbclp.dao.OrganizationDao;
import com.vitsed.jdbclp.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class DaoUtils {

    public static final String createOperation = "CREATE";
    public static final String readOperation = "READ";
    public static final String updateOperation = "UPDATE";
    public static final String deleteOperation = "DELETE";
    public static final String cleanupOperation = "TRUNCATE";

    public static void printOrganizations(List<Organization> orgs, String operation) {
        System.out.println("\n********** printing organizations after " + operation + " operation **********");
        for(var org : orgs) {
            System.out.println(org);
        }
    }

    public static void  printSuccessFailure(String operation, boolean param) {
        if(param) {
            System.out.println("\nOperation " + operation + " successful");
        } else {
            System.out.println("\nOperation " + operation + " failed");
        }
    }

    public static void createSeedData(OrganizationDao dao) {
        Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
        Organization org2 = new Organization("BMW", 1929, "12345", 5501, "We build ultimate Driving machines");
        Organization org3 = new Organization("Google", 1996, "77598", 4567, "Don't be evil");

        List<Organization> orgs = new ArrayList<>();
        orgs.add(0, org1);
        orgs.add(1, org2);
        orgs.add(2, org3);

        int createCount = 0;
        for(var org : orgs) {
            boolean isCreated = dao.create(org);
            if(isCreated) {
                createCount += 1;
            }
        }
        System.out.println("Created " + createCount + " organizations");
    }

}
