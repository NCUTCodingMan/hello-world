package com.rain.service.impl;

import javax.jws.WebService;

import com.rain.domian.Customer;
import com.rain.service.FactoryService;

/**
 * SEI 实现类
 * */
@WebService
public class FactoryServiceImpl implements FactoryService {
	public Customer selectMaxAgeStudent(Customer c1, Customer c2) {
		if(c1.getBirthday().compareTo(c2.getBirthday()) > 0){
			return c1;
		}
		return c2;
	}

	public Customer selectMaxLongNameStudent(Customer c1, Customer c2) {
		if(c1.getName().length() > c2.getName().length()){
			return c1;
		}
		return c2;
	}
	
}
