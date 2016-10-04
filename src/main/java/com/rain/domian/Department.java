package com.rain.domian;

import com.rain.annotation.SQLInteger;
import com.rain.annotation.SQLString;
import com.rain.annotation.Table;

@Table(name = "Department")
public class Department {
	@SQLInteger(name = "id",length = 9,primaryKey = true)
	private int id;
	@SQLString(name = "departmentName",length = 100)
	private String departmentName;
	@SQLInteger(name = "departmentNo",length = 9)
	private int departmentNo;
	@SQLString(name = "address",length = 100)
	private String address;
	@SQLInteger(name = "companyNo",length = 9,foreignKey = true)
	private int companyNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
}
