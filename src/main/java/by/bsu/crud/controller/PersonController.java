package by.bsu.crud.controller;

import by.bsu.crud.dto.PersonForm;
import by.bsu.crud.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public String createPerson(@Valid PersonForm form, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute(personService.findAll());
            return "home";
        }
        personService.create(form);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable Long id, Model model) {
        model.addAttribute(PersonForm.from(personService.findById(id)));
        return "person";
    }

    @PostMapping("/{id}")
    public String updatePerson(@PathVariable Long id, @Valid PersonForm form, Errors errors) {
        if (errors.hasErrors()) {
            return "person";
        }
        personService.update(id, form);
        return "redirect:/person/{id}";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return "redirect:/";
    }
}
