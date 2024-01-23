package br.com.shinobi.demo.service;


import br.com.shinobi.demo.models.Usuario;
import br.com.shinobi.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public void CriarUsuario(Usuario user){
        repository.save(user);
    }

}
