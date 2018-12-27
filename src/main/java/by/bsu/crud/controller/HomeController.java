package by.bsu.crud.controller;

import by.bsu.crud.dto.PersonForm;
import by.bsu.crud.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PersonService personService;

    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping({"/", "/person"})
    public String home(Model model) {
        model.addAttribute(personService.findAll());
        model.addAttribute(new PersonForm());
        return "home";
    }
}
