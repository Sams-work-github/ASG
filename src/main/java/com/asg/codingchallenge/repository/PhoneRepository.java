package com.asg.codingchallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asg.codingchallenge.data.customer.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	List<Phone> findByCustomerName(String customerName);
	Phone findByNumber(long phoneNumber);
	
}
