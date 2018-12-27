package by.bsu.crud.service;

import by.bsu.crud.dto.PersonForm;
import by.bsu.crud.model.PersonRepository;
import by.bsu.crud.model.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void update(Long id, PersonForm form) {
        Person person = findById(id);
        person.setFirstName(form.getFirstName());
        person.setLastName(form.getLastName());
    }

    public void create(PersonForm form) {
        personRepository.save(form.toPerson());
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
