/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.kisoft.research.services;

import lombok.Data;

/**
 *
 * @author tareq
 */
@Data
public class TodoListItem {

    private String name;
    private String notes;
    private String listName;
    private TodoListItemStatus status = TodoListItemStatus.TODO;



}
