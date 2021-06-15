/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.research.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tareq
 */
public class TodoListItemDao {

    private static final Map<String, TodoListItem> items = new HashMap<>();

    public void persist(TodoListItem item) {
        items.put(item.getName(), item);
    }

    void deleteByListNameAndItemName(String listName, String itemName) {
        items.values().stream()
                .filter(item -> item.getListName().equals(listName))
                .filter(item -> item.getName().equals(itemName))
                .forEach(item -> items.remove(item.getName()));
    }

    void updateItemStatus(String itemName, TodoListItemStatus status) {
        items.get(itemName).setStatus(status);
    }

    List<TodoListItem> findByListName(String name) {
        return items.values().stream().filter(item -> item.getListName().equals(name))
                .collect(Collectors.toList());
    }

}
