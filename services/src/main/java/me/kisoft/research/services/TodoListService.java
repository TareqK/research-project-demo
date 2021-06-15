/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.research.services;

import java.util.List;

/**
 *
 * @author tareq
 */
public class TodoListService {

    private final TodoListDao todoListDao = new TodoListDao();
    private final TodoListItemDao todoListItemDao = new TodoListItemDao();

    public List<TodoList> getAll() {
        return todoListDao.findAll();
    }

    public TodoList getByName(String name) {
        return todoListDao.findByName(name);
    }

    public void create(TodoList todoList) {
        todoListDao.persist(todoList);
    }

    public void addItemToList(String listName, TodoListItem item) {
        item.setListName(listName);
        todoListItemDao.persist(item);
    }

    public void removeItemFromList(String listName, String itemName) {
        todoListItemDao.deleteByListNameAndItemName(listName, itemName);
    }

    public void updateItemStatus(String itemName, TodoListItemStatus status) {
        todoListItemDao.updateItemStatus(itemName, status);
    }

    List<TodoListItem> getTodoListItems(String name) {
        return todoListItemDao.findByListName(name);
    }

}
