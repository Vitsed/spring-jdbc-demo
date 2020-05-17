package com.vitsed.jdbclp.dao;

import java.util.List;

import javax.sql.DataSource;

import com.vitsed.jdbclp.domain.Organization;

public interface OrganizationDao {
	
	// Настройка соединения с базой данных
	public void setDataSource(DataSource ds); 
	
	// Создать запись в таблице Organization
	public boolean create(Organization org);
	
	public Organization getOrganization(Integer id);
	
	public List<Organization> getAllOrganizations();

	public boolean delete(Organization org);
	
	public boolean update(Organization org);
	
	public void cleanup();
	
}
