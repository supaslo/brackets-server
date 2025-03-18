package com.overboardsb.brackets.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.model.request.UserRequest;
import com.overboardsb.brackets.model.response.UserResponse;
import com.overboardsb.brackets.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/user/{userId}")
	public String deleteUser(@NonNull @PathVariable("userId") Integer userId) throws SQLException {
		return userService.deleteUser(userId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	public ArrayList<UserResponse> getUsers() throws SQLException {
		return userService.getUsers();
	}	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user/{userId}")
	public UserResponse getUserByUserId(@NonNull @PathVariable("userId") Integer userId) throws SQLException {
		return userService.getUserByUserId(userId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PatchMapping("/user/{tournamentId}")
    public UserResponse patchUser(@NonNull @PathVariable("userId") Integer userId, @RequestBody UserRequest user) {
    	return userService.updateUser(user);
    }	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user")
    public UserResponse postUser(@RequestBody UserRequest user) {
        
        return userService.createUser(user);

    }
}
