package com.app.maikao_app.Controller.Autenticacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.maikao_app.Model.Autenticacao.Endereco;
import com.app.maikao_app.Model.Autenticacao.Usuario;
import com.app.maikao_app.Service.Interface.EnderecoService;
import com.app.maikao_app.Service.Interface.UsuarioService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        try {
            return new ResponseEntity<>(enderecoService.listarEnderecos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cadastrar/{idUsuario}")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco, @PathVariable Long idUsuario) {
        try {
            Usuario usuario =  usuarioService.buscarUsuarioPorId(idUsuario);

            if (usuario == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            endereco.setUsuario(usuario);
            return new ResponseEntity<>(enderecoService.cadastrarEndereco(endereco), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
