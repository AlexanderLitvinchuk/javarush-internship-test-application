package com.game.service.impl;

import com.game.entity.Player;
import com.game.exception.BadRequestException;
import com.game.exception.NotFoundRequestException;
import com.game.repository.PlayerRepository;
import com.game.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Iterable<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Integer getPlayersCount() {
        long count = playerRepository.count();
        return Long.bitCount(count);
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long id) {
        if (id < 0) throw new BadRequestException("ID is not valid");

        Optional<Player> player = playerRepository.findById(id);

        if (!player.isPresent()) throw new NotFoundRequestException("Player not found to database");

        return player.get();
    }
}
