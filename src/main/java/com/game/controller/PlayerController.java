package com.game.controller;

import com.game.entity.Player;
import com.game.service.PlayerService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("players")
    public Player getPlayersCount(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping("players/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }
}
