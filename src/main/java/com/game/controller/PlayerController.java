package com.game.controller;

import com.game.entity.Player;
import com.game.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("players")
    public Iterable<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("players/count")
    public Integer getPlayersCount() {
        return playerService.getPlayersCount();
    }
}
