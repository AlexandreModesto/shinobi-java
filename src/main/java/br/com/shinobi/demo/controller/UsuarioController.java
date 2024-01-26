package br.com.shinobi.demo.controller;


import br.com.shinobi.demo.models.Usuario;
import br.com.shinobi.demo.service.UsuarioService;
import br.com.shinobi.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping(value = "/cadastro")
    public ModelAndView cadastroView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Usuario/Cadastro");
        return mv;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuarioObject) throws Exception{
        try {
            service.salvarUsuario(usuarioObject);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

    @GetMapping(value = "/login")
    public ModelAndView loginView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Usuario/Login");
        return mv;
    }

    @PostMapping(value = "/logar")
    public ResponseEntity<?> logarUsuario(@RequestBody Usuario usuario) throws Exception{
        Usuario userLogin = service.realizarLogin(usuario.getUsername(), Util.md5(usuario.getPassword()));
        if(userLogin == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username ou senha incorreta");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }
    }
}
