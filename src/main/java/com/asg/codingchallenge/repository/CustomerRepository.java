package com.asg.codingchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asg.codingchallenge.data.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
