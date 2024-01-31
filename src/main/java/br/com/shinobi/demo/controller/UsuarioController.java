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
    public ModelAndView RegisterView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Usuario/Cadastro");
        return mv;
    }

}
