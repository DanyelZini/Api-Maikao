package com.app.maikao_app.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.maikao_app.Model.Autenticacao.Usuario;
import com.app.maikao_app.Repository.UsuarioRepository;
import com.app.maikao_app.Service.Interface.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    } 

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorEmaileSenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}
