package com.Todo.ToDoList.model.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserDetailsInfo {

    private UserDetailsInfoHeader userDetailsInfoHeader;
    private UserDetailsInfoPayload userDetailsInfoPayload;
    private String token;

    public UserDetailsInfo(UserDetailsInfoHeader userDetailsInfoHeader,
                           UserDetailsInfoPayload userDetailsInfoPayload,
                           String token) {
        this.userDetailsInfoHeader = userDetailsInfoHeader;
        this.userDetailsInfoPayload = userDetailsInfoPayload;
        this.token = token;
    }
}


