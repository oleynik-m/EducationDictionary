package phoenixit.education.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import phoenixit.education.exceptions.EducationAlreadyExistsException;
import phoenixit.education.exceptions.EducationNotFoundException;
import phoenixit.education.models.Education;
import phoenixit.education.services.EducationService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private static final Logger logger = LogManager.getLogger(EducationController.class);

    @Autowired
    private EducationService educationService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Created")
    public void createEducation(@RequestBody Education education) throws EducationAlreadyExistsException {
        Optional<Education> check = this.educationService.getByName(education.getName());
        if (check.isPresent()) {
            throw new EducationAlreadyExistsException(String.format("Education %s already exists",education.getName()));
        } else
            this.educationService.create(education);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Updated")
    public void updateEducation(@RequestBody Education education, @PathVariable Long id) {
        Optional<Education> check = this.educationService.getById(id);
        if (check.isEmpty())
            throw new EducationNotFoundException(String.format("Education isn't exists"));
        else
            this.educationService.update(education);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Deleted")
    public void deleteEducation(@PathVariable Long id) {
        Optional<Education> education = this.educationService.getById(id);
        if (education.isEmpty())
            throw new EducationNotFoundException("Education isn't exists");
        else
            this.educationService.delete(education.get());
    }

    @GetMapping
    public List<Education> getAllEducations() {
        return this.educationService.getAll();
    }

    @GetMapping(value = "/id/{id}")
    public Education getEducationById(@PathVariable Long id) {
        return this.educationService.getById(id).orElseThrow(() ->new EducationNotFoundException(
                String.format("Couldn't find education by id %d",id)));
    }

    @GetMapping("/name/{name}")
    public Education getEducationByName(@PathVariable String name) {
        return this.educationService.getByName(name).orElseThrow(() ->new EducationNotFoundException(
                String.format("Couldn't find education by name %s",name)));
    }


}
