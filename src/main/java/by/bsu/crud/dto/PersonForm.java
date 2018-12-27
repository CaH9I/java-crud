package by.bsu.crud.dto;

import by.bsu.crud.model.entity.Person;

import javax.validation.constraints.NotBlank;

public class PersonForm {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public static PersonForm from(Person person) {
        PersonForm form = new PersonForm();
        form.firstName = person.getFirstName();
        form.lastName = person.getLastName();
        return form;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person toPerson() {
        return Person.create(firstName, lastName);
    }
}
