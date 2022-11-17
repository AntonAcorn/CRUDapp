package ru.acorn.CRUDapp.dao;

import org.springframework.stereotype.Component;
import ru.acorn.CRUDapp.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component //получаем людей, а в контроллере кладем их в модель
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT , "Joe"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT,"Ton"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
       return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}