package com.asg.codingchallenge.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asg.codingchallenge.data.customer.Phone;
import com.asg.codingchallenge.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	PhoneRepository phoneRepo;
	
	public Set<Long> getAllPhoneNumbers() {
		List<Phone> phones = getAllPhones();
		return getPhoneNumber(phones);
	}

	public Set<Long> getAllPhoneNumbersForCustomer(String customerName) {
		List<Phone> phones = getAllPhonesForCustomer(customerName);
		return getPhoneNumber(phones);
	}

	public boolean activatePhone(long phoneNumber) {
		Phone phone = getPhone(phoneNumber);
		if(phone != null) {
			if(phone.isActive()) {
				return true;
			}
			
			phone.setActive(true);
			phone = save(phone);
			return phone.isActive();
		}
		
		return false;
	}

	public Phone save(Phone phone) {
		return phoneRepo.save(phone);
	}

	public List<Phone> getAllPhones() {
		return phoneRepo.findAll();
	}
	
	public List<Phone> getAllPhonesForCustomer(String customerName) {
		return phoneRepo.findByCustomerName(customerName);
	}
	
	public Phone getPhone(long phoneNumber) {
		return phoneRepo.findByNumber(phoneNumber);
	}
	
	private Set<Long> getPhoneNumber(List<Phone> phones) {
		return phones.stream().map(Phone::getNumber).collect(Collectors.toSet());
	}

}
