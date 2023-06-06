package com.ust.app.customerapp.service;

import java.time.LocalDate;
import java.util.List;

import com.ust.app.customerapp.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	public Customer getCustomer(int id);
	public Customer getCustomerByName(String name);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int id);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByEmail(String email);
	public List<Customer> getCustomerByDob(LocalDate from ,LocalDate to);
	public List<Customer> getCustomerByIdRange(int start ,int end);
}
