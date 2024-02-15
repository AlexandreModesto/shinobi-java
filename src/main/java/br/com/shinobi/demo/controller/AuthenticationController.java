package br.com.shinobi.demo.controller;

import br.com.shinobi.demo.models.*;
import br.com.shinobi.demo.repository.PlayerRepository;
import br.com.shinobi.demo.repository.UsuarioRepository;
import br.com.shinobi.demo.service.TokenService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlayerRepository playerRepository;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(),data.password());
        System.out.println(usernamePassword);

        var auth = authenticationManager.authenticate(usernamePassword);
        Usuario user = usuarioRepository.findByUsernameUser(data.username());
        var token = tokenService.generateToken(user);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if(usuarioRepository.findByEmail(data.email()) != null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Email já em uso");
        }

        else if (usuarioRepository.findByPlayerName(data.playerName()) != null)return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Erro: Nome de jogador já em uso.");

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario novoUsuario = new Usuario(data.username(),encryptedPassword,data.email(),UserRole.USER,false);
        Player novoPlayer = new Player(data.playerName(), 1);
        playerRepository.save(novoPlayer);
        novoUsuario.setPlayerName(novoPlayer);
        usuarioRepository.save(novoUsuario);


        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
