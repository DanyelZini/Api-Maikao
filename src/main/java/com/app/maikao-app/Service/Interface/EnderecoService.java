package com.app.maikao_app.Service.Interface;

import java.util.List;

import com.app.maikao_app.Model.Autenticacao.Endereco;

public interface EnderecoService {
    public Endereco cadastrarEndereco(Endereco endereco);
    public List<Endereco> listarEnderecos();
}
