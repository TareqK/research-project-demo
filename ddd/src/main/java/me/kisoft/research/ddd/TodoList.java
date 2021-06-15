/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.research.ddd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Data;

/**
 *
 * @author tareq
 */
@Data
public class TodoList {
    
    private static final Map<String, TodoList> lists = new HashMap<>();
    
    private String name;
    private Set<TodoListItem> items = new HashSet<>();
    
    public static final List<TodoList> findAll() {
        return lists.values().stream().collect(Collectors.toList());
    }
    
    public static final TodoList findByName(String name) {
        return lists.getOrDefault(name, null);
    }
    
    public void addTodoItem(TodoListItem item) {
        item.setList(this);
        items.add(item);
        this.save();
    }
    
    public TodoListItem getItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName() != null)
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    
    public void removeItem(TodoListItem item) {
        item.setList(null);
        items.remove(item);
        this.save();
    }
    
    public void save() {
        lists.put(this.name, this);
        this.items.stream().forEach(item -> item.save());
    }
}
