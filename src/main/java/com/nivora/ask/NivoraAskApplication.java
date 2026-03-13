package com.nivora.ask;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NivoraAskApplication {

	public static void main(String[] args) {
		System.out.println("running project");
		Dotenv dotenv = Dotenv.configure()
				.directory("Nivora-Ask")
				.load();
		dotenv.entries().forEach( (DotenvEntry entry) -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(NivoraAskApplication.class, args);
	}

}
