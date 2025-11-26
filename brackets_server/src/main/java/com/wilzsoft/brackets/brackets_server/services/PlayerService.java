package com.wilzsoft.brackets.brackets_server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilzsoft.brackets.brackets_server.dao.repository.PlayerRepository;
import com.wilzsoft.brackets.brackets_server.domain.entity.Player;
import com.wilzsoft.brackets.brackets_server.model.request.PlayerRequest;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player getPlayerByPlayerId(Integer playerId) {

        Player player = new Player();
        Optional<Player> dbPlayer = playerRepository.findById(playerId);
        if (dbPlayer.isPresent()) {
            player = dbPlayer.get();
        }
        return player;
        
    }

    public List<Player> getAllPlayers() {

        List<Player> players = playerRepository.findAll();
        return players;
        
    }

    public void createPlayer(PlayerRequest player) {

        Player newPlayer = new Player();

        newPlayer.setFirstname(player.getFirstName());
        newPlayer.setLastname(player.getLastName());

        playerRepository.save(newPlayer);

    }
}
