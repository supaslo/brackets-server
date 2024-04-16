package com.overboardsb.brackets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.PlayerRepository;
import com.overboardsb.brackets.domain.entity.Player;
import com.overboardsb.brackets.model.PlayerRequest;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void createPlayer(PlayerRequest player) {

        Player newPlayer = new Player();

        newPlayer.setFirstname(player.getFirstName());
        newPlayer.setLastname(player.getLastName());

        playerRepository.save(newPlayer);

    }
}
