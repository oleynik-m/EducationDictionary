package phoenixit.education.services;

import phoenixit.education.models.Education;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    Education create (Education education);
    void delete (Education education);
    Education update (Education education);
    List<Education> getAll ();
    Optional<Education> getById (Long id);
    Optional<Education> getByName (String name);

}
