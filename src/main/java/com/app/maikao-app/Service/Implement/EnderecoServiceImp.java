package com.app.maikao_app.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.maikao_app.Model.Autenticacao.Endereco;
import com.app.maikao_app.Repository.EnderecoRepository;
import com.app.maikao_app.Service.Interface.EnderecoService;

@Service
public class EnderecoServiceImp implements EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco cadastrarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

}
