package com.marcos.LiterAlura;

import com.marcos.LiterAlura.Service.ApiUsage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var apiReq = new ApiUsage();
		var json = apiReq.apiRequest("https://gutendex.com/books/?search=La%20Divina%20Comedia");
		System.out.println(json);
	}
}
