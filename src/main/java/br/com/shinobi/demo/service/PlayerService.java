package br.com.shinobi.demo.service;


import br.com.shinobi.demo.models.Player;
import br.com.shinobi.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Optional<Player> retornarPlayer(Long id) throws Exception{
        try{
            Optional<Player> player = repository.getPlayerById(id);
            return player;
        }catch (Exception e){
            return null;
        }
    }
}
