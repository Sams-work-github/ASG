package com.asg.codingchallenge.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.asg.codingchallenge.data.customer.Customer;
import com.asg.codingchallenge.data.customer.Phone;
import com.asg.codingchallenge.repository.CustomerRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	CustomerRepository customerRepo;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        insertSeedData();
    }

    private void insertSeedData() {
    	Customer customer1 = new Customer();
		List<Phone> phones1 = new ArrayList<>();
		
		Phone phone1 = new Phone();
		phone1.setNumber(40123123);
		phone1.setCustomer(customer1);
		phones1.add(phone1);
		
		customer1.setName("abc");
		customer1.setPhones(phones1);
		customerRepo.save(customer1);
		
		Customer customer2 = new Customer();
		List<Phone> phones2 = new ArrayList<>();
		
		Phone phone2 = new Phone();
		phone2.setNumber(40789789);
		phone2.setCustomer(customer2);
		phones2.add(phone2);
		
		Phone phone3 = new Phone();
		phone3.setNumber(40555555);
		phone3.setCustomer(customer2);
		phones2.add(phone3);
		
		customer2.setName("xyz");
		customer2.setPhones(phones2);
		customerRepo.save(customer2);
    }

}