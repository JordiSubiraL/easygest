package com.easygest.bill_service;

import org.springframework.boot.SpringApplication;

public class TestBillServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(BillServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
