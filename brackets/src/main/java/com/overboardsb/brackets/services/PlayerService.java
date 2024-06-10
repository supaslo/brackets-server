package com.overboardsb.brackets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.PlayerRepository;
import com.overboardsb.brackets.domain.entity.Player;
import com.overboardsb.brackets.model.request.PlayerRequest;

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
