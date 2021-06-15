/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.research.services;

import io.javalin.http.Context;

/**
 *
 * @author tareq
 */
public class TodoListController {

    private final TodoListService service = new TodoListService();

    public void getAllTodoLists(Context ctx) {
        ctx.json(service.getAll());
    }

    public void getTodoListByName(Context ctx) {
        String name = ctx.pathParam("name");
        ctx.json(service.getByName(name));
    }

    public void getTodoListItems(Context ctx) {
        String name = ctx.pathParam("name");
        ctx.json(service.getTodoListItems(name));
    }

    public void createTodoList(Context ctx) {
        service.create(ctx.bodyAsClass(TodoList.class));
    }

    public void addItemToList(Context ctx) {
        String listName = ctx.pathParam("name");
        TodoListItem item = ctx.bodyAsClass(TodoListItem.class);
        service.addItemToList(listName, item);
    }

    public void removeItemFromList(Context ctx) {
        String listName = ctx.pathParam("name");
        String itemName = ctx.pathParam("item_name");
        service.removeItemFromList(listName, itemName);
    }

    public void updateTodoItemStatus(Context ctx) {
        String listName = ctx.pathParam("name");
        String itemName = ctx.pathParam("item_name");
        TodoListItemStatus status = ctx.bodyAsClass(TodoListItemStatus.class);
        service.updateItemStatus(itemName, status);
    }
}
