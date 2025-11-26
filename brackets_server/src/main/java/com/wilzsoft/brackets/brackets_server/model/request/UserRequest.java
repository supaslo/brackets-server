package com.wilzsoft.brackets.brackets_server.model.request;

import java.util.Date;

import lombok.Data;

@Data
public class UserRequest {
 
    private Integer id;

    private String userId;

    private String firstName;

    private String lastName;

    private String role;

    private Date createdDate;

    private Date updatedDate;
    
}
