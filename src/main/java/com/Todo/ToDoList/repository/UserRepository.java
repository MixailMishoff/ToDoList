package com.Todo.ToDoList.repository;

import com.Todo.ToDoList.model.Category;
import com.Todo.ToDoList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
