package com.marcos.LiterAlura;

import com.marcos.LiterAlura.Repository.IAuthorRepository;
import com.marcos.LiterAlura.View.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private IAuthorRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Application application = new Application(repository);
		application.showMenu();
	}
}
