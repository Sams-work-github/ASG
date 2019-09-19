package com.asg.codingchallenge.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.asg.codingchallenge.data.customer.Phone;
import com.asg.codingchallenge.repository.PhoneRepository;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceTest {

	@InjectMocks
	PhoneService service = new PhoneService();
	
	@Mock
	PhoneRepository phoneRepo;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllPhoneNumbers() {
		List<Phone> mockPhones = getPhones();
		when(phoneRepo.findAll()).thenReturn(mockPhones);
		Set<Long> phones = service.getAllPhoneNumbers();
		assertEquals(mockPhones.size(), phones.size());
	}
	
	@Test
	public void getAllPhoneNumbersForCustomer() {
		List<Phone> mockPhones = getPhones();
		when(phoneRepo.findByCustomerName("abc")).thenReturn(mockPhones);
		Set<Long> phones = service.getAllPhoneNumbersForCustomer("abc");
		assertEquals(mockPhones.size(), phones.size());
	}
	
	@Test
	public void activatePhone() {
		long phoneNumber = 40123123;
		Phone phone = new Phone();
		phone.setNumber(phoneNumber);
		when(phoneRepo.findByNumber(phoneNumber)).thenReturn(phone);
		when(phoneRepo.save(phone)).thenReturn(getActivatedPhone());
		boolean activated = service.activatePhone(phoneNumber);
		assertEquals(true, activated);
	}
	
	@Test
	public void activatePhoneWhenPhoneDoesntExist() {
		long phoneNumber = 40123123;
		when(phoneRepo.findByNumber(phoneNumber)).thenReturn(null);
		boolean activated = service.activatePhone(phoneNumber);
		assertEquals(false, activated);
	}
	
	@Test
	public void activatePhoneWhenPhoneAlreadyActive() {
		long phoneNumber = 40123123;
		when(phoneRepo.findByNumber(phoneNumber)).thenReturn(getActivatedPhone());
		boolean activated = service.activatePhone(phoneNumber);
		assertEquals(true, activated);
	}

	private Phone getActivatedPhone() {
		Phone phone = new Phone();
		phone.setActive(true);
		return phone;
	}

	private List<Phone> getPhones() {
		List<Phone> phones = new ArrayList<>();
		Phone phone1 = new Phone();
		phone1.setNumber(40123123);
		phones.add(phone1);
		
		Phone phone2 = new Phone();
		phone2.setNumber(40789789);
		phones.add(phone2);
		
		return phones;
	}
}
