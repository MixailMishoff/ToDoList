package com.Todo.ToDoList.dto;

import com.Todo.ToDoList.model.Task;
import com.Todo.ToDoList.model.User;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
    private String name;
    private User user;
    private List<Task> tasks = new ArrayList<>();
}