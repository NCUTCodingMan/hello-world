package com.rain.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.rain.domian.Customer;

/**
 * SEI 接口
 * */
@WebService
public interface FactoryService {
	@WebMethod
	Customer selectMaxAgeStudent(Customer c1, Customer c2);
	@WebMethod
	Customer selectMaxLongNameStudent(Customer c1, Customer c2);
}