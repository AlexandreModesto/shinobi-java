package br.com.shinobi.demo.controller;


import br.com.shinobi.demo.models.Usuario;
import br.com.shinobi.demo.service.ServiceExcept;
import br.com.shinobi.demo.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "user")
public class UsuarioControllerBFF {

    @Autowired
    UsuarioService service;

    @GetMapping(value = "cadastro")
    public ModelAndView CadastroView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Usuario/Cadastro");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @GetMapping(value = "login")
    public ModelAndView LoginView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Usuario/Login");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping(value = "salvar")
    public ModelAndView CadastroPost(Usuario usuario) throws Exception{
        ModelAndView mv = new ModelAndView();
        service.salvarUsuario(usuario);
        mv.setViewName("redirect:cadastro");
        return mv;
    }

    @PostMapping(value = "/login")
    public ModelAndView LoginPost(Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException,ServiceExcept {
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario",new Object());
        if(br.hasErrors()){
            mv.setViewName("Usuario/Login");
        }
        Usuario userLogin = service.realizarLogin(usuario.getUsername(), usuario.getPassword());
        if(userLogin == null){
            mv.addObject("msg","Usuário não encontrado");
        }else {
            session.setAttribute("usuarioLogado",userLogin);
            return CadastroView();
        }
        return mv;
    }

}
