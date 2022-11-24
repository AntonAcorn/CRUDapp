package ru.acorn.CRUDapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.acorn.CRUDapp.models.Item;
import ru.acorn.CRUDapp.models.Person;

import java.util.List;

@Repository//здесь мы создаем кастомные методы и их обязательно нужно будет реализовать в сервисе
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String name);

    //person.getItems() ==
    List<Item> findByOwner(Person owner);

}
