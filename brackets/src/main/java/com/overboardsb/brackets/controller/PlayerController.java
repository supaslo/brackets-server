package com.overboardsb.brackets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.overboardsb.brackets.model.PlayerRequest;
import com.overboardsb.brackets.services.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    @CrossOrigin(origins = "http://localhost:3000")
    public String postPlayer(@RequestBody PlayerRequest player) {
        
        playerService.createPlayer(player);
        return "Update successful";

    }
    

}
