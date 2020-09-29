package com.capgemini.flight.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.flight.entity.Customer;

@Repository
public interface LoginDAO extends JpaRepository<Customer, String>{

	@Query(value="select * from customer where user_password=?1",nativeQuery=true) //Retreive details of customer using userPassword
	List<Customer> checkforPassword(String userPassword);
	
	@Query(value="select * from customer where user_name=?1",nativeQuery=true) //Retreive details of customer using userPassword
	List<Customer> checkforUsername(String userName);	 

}