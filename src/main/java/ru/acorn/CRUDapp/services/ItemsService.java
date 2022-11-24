package ru.acorn.CRUDapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.acorn.CRUDapp.models.Item;
import ru.acorn.CRUDapp.models.Person;
import ru.acorn.CRUDapp.repositories.ItemsRepository;

import java.util.List;

//мы не можем напрямую вызывать методы String Data, только через hibernate и Service @Transactional
@Service
@Transactional
public class ItemsService {
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByItemName(String itemName) {
        return itemsRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner) {
        return itemsRepository.findByOwner(owner);
    }


}
