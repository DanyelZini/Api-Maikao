package com.app.maikao_app.Service.Interface;

import java.util.List;

import com.app.maikao_app.Model.Autenticacao.Usuario;

public interface UsuarioService {
    public Usuario cadastrarUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorId(Long id);
    public Usuario buscarUsuarioPorEmaileSenha(String email, String senha);
}
