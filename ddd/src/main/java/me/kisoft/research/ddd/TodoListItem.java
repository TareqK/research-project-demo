/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.research.ddd;

import lombok.Data;

/**
 *
 * @author tareq
 */
@Data
public class TodoListItem {

    private String name;
    private String notes;
    private TodoList list;
    private TodoListItemStatus status = TodoListItemStatus.TODO;

    public void save() {
        //do nothing
    }

    public void updateStatus(TodoListItemStatus newStatus) {
        this.status = newStatus;
        this.save();
    }

}
