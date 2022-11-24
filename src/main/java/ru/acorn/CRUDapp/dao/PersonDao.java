package ru.acorn.CRUDapp.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.acorn.CRUDapp.models.Person;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDao {

    private final EntityManager entityManager;
    @Autowired
    public PersonDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1(){
        Session session = entityManager.unwrap(Session.class); //hibernate service, используя entityManager

//        //1 запрос
//        List <Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
//
//        //N запросов к БД
//        for (Person person: people
//             ) {
//            System.out.println("Person " + person.getName() + " has: " + person.getItems());
//        }

        //Solution SQL left join
        Set<Person> people = new HashSet<Person>(session.createQuery("Select p From Person p left join fetch p.items").
                getResultList());

        for (Person person: people
             ) {
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }
    }
}
