package com.ust.app.customerapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.app.customerapp.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	public Optional<Customer> findByname(String customerName);
	public Optional<Customer> findByemail(String email);
	
	//JPQL
	@Query("from Customer where customerName=:customerName")
	public Optional<Customer> searchByName(@Param("customerName") String customerName);
	
	@Query("from Customer where dob between :from and :to")
	public List<Customer> findDobRange(LocalDate from,LocalDate to);
	
	//Native Query
	@Query(value = "select * from customer_data where id between :start and :end", nativeQuery = true)
	public List<Customer> findIdRange(int start,int end);
}
