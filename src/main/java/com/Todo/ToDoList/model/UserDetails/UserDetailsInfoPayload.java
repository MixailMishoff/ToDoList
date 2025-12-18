package com.Todo.ToDoList.model.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsInfoPayload {
    private String sub;
    private String iss;
    private String exp;
    private String iat;
    private String email;
}
