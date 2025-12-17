package com.Todo.ToDoList.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO {
    private String title;
    private String description;
    private Boolean isCompleted;
}