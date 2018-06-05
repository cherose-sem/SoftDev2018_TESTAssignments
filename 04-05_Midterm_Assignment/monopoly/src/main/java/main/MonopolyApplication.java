package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Cherry Rose Semeña
 */
@SpringBootApplication
@Configuration
@ComponentScan("main")
public class MonopolyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonopolyApplication.class, args);
	}
}
