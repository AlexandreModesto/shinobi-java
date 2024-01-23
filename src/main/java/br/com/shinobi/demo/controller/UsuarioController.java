package br.com.shinobi.demo.controller;


import br.com.shinobi.demo.models.Usuario;
import br.com.shinobi.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping(value = "/save")
    public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario){
        service.CriarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("Criado");
    }

}
