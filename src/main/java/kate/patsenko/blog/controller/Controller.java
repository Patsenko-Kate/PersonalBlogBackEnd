package kate.patsenko.blog.controller;

import kate.patsenko.blog.dao.DAO;
import kate.patsenko.blog.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3002"})
@RestController
public class Controller {
    private final DAO<Person> personDAO;

    public Controller(DAO<Person> personDAO) {
        this.personDAO = personDAO;
    }

    @PostMapping("/add_person")
    public ResponseEntity<Void> createPerson(@RequestBody Person person) {
        personDAO.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}