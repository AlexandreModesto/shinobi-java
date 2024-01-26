package br.com.shinobi.demo.repository;

import br.com.shinobi.demo.models.Player;
import br.com.shinobi.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Usuario u JOIN u.playerName WHERE u.id = :id")
    Optional<Player> getPlayerById(Long id);
}
