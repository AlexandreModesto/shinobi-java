package br.com.shinobi.demo.controller;

import br.com.shinobi.demo.models.Player;
import br.com.shinobi.demo.repository.PlayerRepository;
import br.com.shinobi.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping(value = "/player")
public class PlayerControll {

    @Autowired
    private PlayerService service;


    @GetMapping(value = "/painel")
    public ModelAndView painelView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Player/Painel");
        return mv;
    }

    @GetMapping(value = "/PainelGet")
    public ResponseEntity<?> painelGet(Long id) throws Exception{
        Optional<Player> player = service.retornarPlayer(id);
        return ResponseEntity.status(HttpStatus.OK).body(player.get());
    }
}
