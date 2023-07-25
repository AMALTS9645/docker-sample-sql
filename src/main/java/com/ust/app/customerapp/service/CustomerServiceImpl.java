package com.ust.app.customerapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.app.customerapp.exception.CustomerAlreadyExistsException;
import com.ust.app.customerapp.exception.CustomerNotFoundException;
import com.ust.app.customerapp.model.Customer;
import com.ust.app.customerapp.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;

	
	@Override
	public Customer addCustomer(Customer customer) {
		if(repo.existsById(customer.getId())) {
			throw new CustomerAlreadyExistsException("Customer Already Exists");
		}
		return repo.save(customer);
	}

	
	@Override
	public Customer getCustomer(int id) {
		if(!repo.existsById(id)) {
			throw new CustomerNotFoundException("Customer with id " + id + " not found");
		}
		
//		Customer customer = repo.findById(id)
//				.orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " not found"));
		Customer customer = repo.findById(id).get();
		
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if(!repo.existsById(customer.getId())) {
			throw new CustomerNotFoundException("Customer not found");
		}
		return repo.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		if(!repo.existsById(id)) {
			throw new CustomerNotFoundException("Customer not found");
		}
		repo.deleteById(id);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public Customer getCustomerByName(String name) {
		Customer c = repo.findByname(name).orElseThrow(()->new CustomerNotFoundException("Customer not found with name "+ name));
		return c;

	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer c = repo.findByemail(email).orElseThrow(()->new CustomerNotFoundException("Customer not found with email "+ email));
		return c;
	}

	@Override
	public List<Customer> getCustomerByDob(LocalDate from, LocalDate to) {
		return repo.findDobRange(from, to);
	}

	@Override
	public List<Customer> getCustomerByIdRange(int start, int end) {
		return repo.findIdRange(start, end);
	}

}
