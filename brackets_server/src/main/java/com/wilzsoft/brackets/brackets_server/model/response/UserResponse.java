package com.wilzsoft.brackets.brackets_server.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class UserResponse {

    private Integer id;

    private String userId;

    private String firstName;

    private String lastName;

    private String role;

    private Date createdDate;

    private Date updatedDate;

}
