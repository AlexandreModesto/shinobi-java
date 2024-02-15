package br.com.shinobi.demo.controller;


import br.com.shinobi.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "/login")
    public ModelAndView LoginView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Usuario/Login");
        return mv;
    }

}
