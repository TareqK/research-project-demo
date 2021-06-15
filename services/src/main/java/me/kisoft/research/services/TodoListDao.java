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
public class TodoListDao {

    private static final Map<String, TodoList> lists = new HashMap<>();

    List<TodoList> findAll() {
        return lists.values().stream().collect(Collectors.toList());
    }

    TodoList findByName(String name) {
        return lists.values().stream()
                .filter(list -> list.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    void persist(TodoList todoList) {
        lists.put(todoList.getName(), todoList);
    }

}
