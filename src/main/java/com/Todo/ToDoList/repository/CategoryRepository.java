package com.Todo.ToDoList.repository;

import com.Todo.ToDoList.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
