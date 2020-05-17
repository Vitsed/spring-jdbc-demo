package com.vitsed.jdbclp.daoimpl;

import com.vitsed.jdbclp.dao.OrganizationDao;
import com.vitsed.jdbclp.domain.Organization;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class OrganizationDaoImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Organization getOrganization(Integer id) {
        String sqlQuery = "SELECT * FROM organization WHERE id = ?";
        Object[] args = new Object[]{id};
        Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
        return org;
    }

    public List<Organization> getAllOrganizations() {
        String sqlQuery = "SELECT * FROM organization";
        List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
        return orgList;
    }

    public boolean create(Organization org) {
        String sqlQuery = "INSERT INTO organization" +
                "(company_name, year_of_incorporation, postal_code, employee_count, slogan)" +
                "VALUES(?, ?, ?, ?, ?)";
        Object[] args = new Object[]{org.getCompanyName(), org.getYearOfIncorporation(),
                org.getPostalCode(), org.getEmployeeCount(),org.getSlogan()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public boolean delete(Organization org) {
        return false;
    }

    public boolean update(Organization org) {
        return false;
    }

    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE organization";
        jdbcTemplate.execute(sqlQuery);
    }
}
