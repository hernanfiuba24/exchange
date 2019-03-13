package com.exchange.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exchange.model.sistemaSolar.SistemaSolar;

@SpringBootApplication(scanBasePackages={"com.exchange"})
public class ExchangeApplication {

	private static final int DAYS_IN_ANIO = 365;

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
//		SistemaSolar sistemaSolar = new SistemaSolar();
//		for (int i = 0; i < DAYS_IN_ANIO; i++) {
//			System.out.println("Day : " + i);
//			sistemaSolar.move(1);
//			sistemaSolar.print();
//		}
	}

}

