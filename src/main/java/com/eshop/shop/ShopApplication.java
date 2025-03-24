package com.eshop.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
	}

	@GetMapping("/hellow")
	public static String hellow(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return "Hellow" + " " + name;
	}

}
