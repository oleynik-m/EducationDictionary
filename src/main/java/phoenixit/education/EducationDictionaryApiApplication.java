package phoenixit.education;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import phoenixit.education.models.Education;
import phoenixit.education.repositories.EducationRepo;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EducationDictionaryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationDictionaryApiApplication.class, args);
	}



}
