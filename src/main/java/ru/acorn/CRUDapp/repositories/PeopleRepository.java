package ru.acorn.CRUDapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.acorn.CRUDapp.models.Person;

// параметризуем сущностью, Integer - это id
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}

