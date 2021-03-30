package com.somegroup.cardfeed.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somegroup.cardfeed.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>{
	Customer findByName(String name);
}
