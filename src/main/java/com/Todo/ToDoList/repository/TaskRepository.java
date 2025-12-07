package com.Todo.ToDoList.repository;

import com.Todo.ToDoList.model.Category;
import com.Todo.ToDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
