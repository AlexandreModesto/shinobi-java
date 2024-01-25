package br.com.shinobi.demo.service;


import br.com.shinobi.demo.exceptions.CriptoExistException;
import br.com.shinobi.demo.exceptions.EmailExistsException;
import br.com.shinobi.demo.models.Usuario;
import br.com.shinobi.demo.repository.UsuarioRepository;
import br.com.shinobi.demo.util.Util;
import com.google.protobuf.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;


    public void criarUsuario(Usuario objUsuario){
        repository.save(objUsuario);
    }

    public void salvarUsuario(Usuario user) throws Exception{
        try {
            if(repository.findByEmail(user.getEmail()) != null){
                throw new EmailExistsException("Existe email cadastrado para : "+ user.getEmail());
            }
            user.setPassword(Util.md5(user.getPassword()));
        }catch (NoSuchAlgorithmException e){
            throw new CriptoExistException("Erro na criptografia da senha");
        }

        repository.save(user);
    }

    public Usuario realizarLogin(String username, String password) throws ServiceExcept {
        Usuario usuario = repository.checaDadosDeLogin(username,password);
        return usuario;
    }

}
