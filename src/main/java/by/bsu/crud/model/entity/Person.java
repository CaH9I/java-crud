package by.bsu.crud.model.entity;

import org.springframework.util.Assert;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String firstName;

    @Basic(optional = false)
    private String lastName;

    private Person() {}

    public static Person create(String firstName, String lastName) {
        Assert.notNull(firstName, "First name is null");
        Assert.notNull(lastName, "Last name is null");

        Person person = new Person();
        person.firstName = firstName;
        person.lastName = lastName;
        return person;
    }

    public Long getId() {
        return id;
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
}
