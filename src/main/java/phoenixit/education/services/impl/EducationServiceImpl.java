package phoenixit.education.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phoenixit.education.models.Education;
import phoenixit.education.repositories.EducationRepo;
import phoenixit.education.services.EducationService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {

    @Autowired
    EducationRepo educationRepo;

    @Override
    public Education create(Education education) {
       return this.educationRepo.save(education);
    }

    @Override
    public void delete(Education education) {
        this.educationRepo.delete(education);
    }

    @Override
    public Education update(Education education) {
       return this.educationRepo.save(education);
    }

    @Override
    public List<Education> getAll() {
        return this.educationRepo.findAll();
    }

    @Override
    public Optional<Education> getById(Long id) {
        return this.educationRepo.findById(id);
    }

    @Override
    public Optional<Education> getByName(String name) {
        return this.educationRepo.findByName(name);
    }
}
