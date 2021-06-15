/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.research.ddd;

import io.javalin.http.Context;

/**
 *
 * @author tareq
 */
public class TodoListController {

    public void getAllTodoLists(Context ctx) {
        ctx.json(TodoList.findAll());
    }

    public void getTodoListByName(Context ctx) {
        String name = ctx.pathParam("name");
        ctx.json(TodoList.findByName(name));
    }

    public void createTodoList(Context ctx) {
        ctx.bodyAsClass(TodoList.class).save();
    }

    public void addItemToList(Context ctx) {
        String listName = ctx.pathParam("name");
        TodoList list = TodoList.findByName(listName);
        TodoListItem item = ctx.bodyAsClass(TodoListItem.class);
        list.addTodoItem(item);
    }

    public void removeItemFromList(Context ctx) {
        String listName = ctx.pathParam("name");
        TodoList list = TodoList.findByName(listName);
        TodoListItem item = ctx.bodyAsClass(TodoListItem.class);
        list.removeItem(item);
    }

    public void updateTodoItemStatus(Context ctx) {
        String listName = ctx.pathParam("name");
        String itemName = ctx.pathParam("item_name");
        TodoList list = TodoList.findByName(listName);
        TodoListItemStatus status = ctx.bodyAsClass(TodoListItemStatus.class);
        list.getItemByName(itemName).updateStatus(status);
    }
}
