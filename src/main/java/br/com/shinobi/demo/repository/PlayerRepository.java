package br.com.shinobi.demo.repository;

import br.com.shinobi.demo.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {

}
