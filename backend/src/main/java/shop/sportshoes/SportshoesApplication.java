package shop.sportshoes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportshoesApplication {

	private static final Logger logger = LogManager.getLogger(SportshoesApplication.class);
	public static void main(String[] args) {

		logger.trace("1.This is a TRACE message.");
		logger.debug("2.This is a DEBUG message.");
		logger.info("3.This is an INFO message.");
		logger.warn("4.This is a WARN message.");
		logger.error("5.This is an ERROR message.");

		SpringApplication.run(SportshoesApplication.class, args);
	}
}