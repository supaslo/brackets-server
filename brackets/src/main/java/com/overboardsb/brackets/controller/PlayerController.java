package com.overboardsb.brackets.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.overboardsb.brackets.domain.entity.Player;
import com.overboardsb.brackets.model.request.PlayerRequest;
import com.overboardsb.brackets.services.PlayerService;

import lombok.NonNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/player/{playerId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Player getPlayerByPlayerId(@NonNull @PathVariable("playerId") Integer playerId) throws SQLException {
		return playerService.getPlayerByPlayerId(playerId);
	}

    @GetMapping("/players")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Player> getAllPlayers() throws SQLException {
		return playerService.getAllPlayers();
	}

    @PostMapping("/player")
    @CrossOrigin(origins = "http://localhost:3000")
    public String postPlayer(@RequestBody PlayerRequest player) {
        
        playerService.createPlayer(player);
        return "Update successful";

    }
    

}
