package com.game.service.impl;

import com.game.entity.Player;
import com.game.exception.BadRequestException;
import com.game.exception.NotFoundRequestException;
import com.game.repository.PlayerRepository;
import com.game.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Iterable<Player> getPlayers(Specification<Player> specification, Pageable pageable) {
        Page<Player> playerPage = playerRepository.findAll(specification, pageable);
        return playerPage.getContent();
    }

    @Override
    public Integer getPlayersCount(Specification<Player> specification) {
        long count = playerRepository.count(specification);
        return Math.toIntExact(count);
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

    @Override
    public Player updatePlayer(Long id, Player player) {
        Player playerEntity = getPlayerById(id);

        if (player.getName() != null) playerEntity.setName(player.getName());
        if (player.getTitle() != null) playerEntity.setTitle(player.getTitle());
        if (player.getRace() != null) playerEntity.setRace(player.getRace());
        if (player.getProfession() != null) playerEntity.setProfession(player.getProfession());
        if (player.getBirthday() != null) playerEntity.setBirthday(player.getBirthday());
        if (player.getBanned() != null) playerEntity.setBanned(player.getBanned());
        if (player.getExperience() != null) playerEntity.setExperience(player.getExperience());

        return playerRepository.save(playerEntity);
    }

    @Override
    public void deletePlayer(Long id) {
        Player playerEntity = getPlayerById(id);
        playerRepository.delete(playerEntity);
    }
}
