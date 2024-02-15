package br.com.shinobi.demo.repository;

import br.com.shinobi.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("select i from Usuario i where i.username =:username and i.password=:password")
    Usuario checaDadosDeLogin(String username, String password);

    @Query("select i from Usuario i where i.email = :email")
    public Usuario findByEmail(String email);

    @Query("select i from Usuario i where i.username = :username")
    public Usuario findByUsernameUser(String username);

    @Query("select i from Usuario i where i.username = :username")
    UserDetails findByUsername(String username);

    @Query("select p from Player p where p.name = :playerName")
    UserDetails findByPlayerName(String playerName);
}
