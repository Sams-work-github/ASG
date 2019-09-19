package com.asg.codingchallenge.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asg.codingchallenge.service.PhoneService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/phone")
public class PhoneController {

	@Autowired
	PhoneService phoneService;
	
	@GetMapping("/phone-numbers")
	@ApiOperation(value = "Gets all phone numbers", notes = "Gets the list of all phone numbers for all customers")
	public Set<Long> getAllPhoneNumbers() {
		return phoneService.getAllPhoneNumbers();
	}
	
	@GetMapping("/{customerName}/phone-numbers")
	@ApiOperation(value = "Gets all phone numbers attached to a specific customer", notes = "Gets the list of all phone numbers associated with the customer whose name is being passed")
	public Set<Long> getAllPhoneNumbersForCustomer(@PathVariable(name = "customerName") String customerName) {
		return phoneService.getAllPhoneNumbersForCustomer(customerName);
	}
	
	@PutMapping("/activate/{phoneNumber}")
	@ApiOperation(value = "Activates the phone number", notes = "Activates the phone number that is passed")
	public boolean activatePhone(@PathVariable(name = "phoneNumber") long phoneNumber) {
		return phoneService.activatePhone(phoneNumber);
	}
	
}
