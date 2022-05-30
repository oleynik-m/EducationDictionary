package phoenixit.education.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import phoenixit.education.models.Education;
import phoenixit.education.repositories.EducationRepo;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PreLoad {
    private static final Logger logger = LogManager.getLogger(PreLoad.class);


    @Bean
    CommandLineRunner initDatabase(EducationRepo educationRepo) {

        return args -> {
            try {
                List<Education> data = Arrays.asList(
                        new Education("Non-Formal"),
                        new Education("Special Education"),
                        new Education("Preschool"),
                        new Education("High school")
                );
                educationRepo.saveAll(data);
            } catch (Exception e) {
                logger.error(e);
            }

        };
    }
}
