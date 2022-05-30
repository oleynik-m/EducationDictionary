package phoenixit.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import phoenixit.education.models.Education;

import java.util.Optional;

public interface EducationRepo extends JpaRepository<Education,Long> {
    Optional<Education> findByName (String name);
}
