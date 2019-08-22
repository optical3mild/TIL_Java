package com.home.app;

public class Customer {
	//필드 -- 외부의 자판기 객체를 저장.
	private VendingMachine vm;
	
	public Customer(VendingMachine vm) {
		this.vm = vm;
	}
}
