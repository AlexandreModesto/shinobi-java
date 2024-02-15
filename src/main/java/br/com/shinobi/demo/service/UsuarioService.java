package br.com.shinobi.demo.service;


import br.com.shinobi.demo.exceptions.CriptoExistException;
import br.com.shinobi.demo.exceptions.EmailExistsException;
import br.com.shinobi.demo.models.Usuario;
import br.com.shinobi.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;


    public void salvarUsuario(Usuario user) throws Exception{
        try {
            if(repository.findByEmail(user.getEmail()) != null){
                throw new EmailExistsException("Existe email cadastrado para : "+ user.getEmail());
            }
            user.setPassword(user.getPassword());
        }catch (Exception e){
            throw new CriptoExistException("Erro na criptografia da senha");
        }

        repository.save(user);
    }

    public Usuario realizarLogin(String username, String password) throws ServiceExcept {

        Usuario usuario = repository.checaDadosDeLogin(username,password);
        if(usuario != null){
            usuario.setOnline(true);
            repository.save(usuario);
        }
        return usuario;
    }

}
