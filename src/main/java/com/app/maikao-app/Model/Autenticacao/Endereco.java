package com.app.maikao_app.Model.Autenticacao;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "cep", nullable = false, unique = false, length = 8)
    private Integer cep;
    @Column(name = "estado", nullable = false, unique = false)
    private String estado;
    @Column(name = "cidade", nullable = false, unique = false)
    private String cidade;
    @Column(name = "bairro", nullable = false, unique = false)
    private String bairro;
    @Column(name = "rua", nullable = false, unique = false)
    private String rua;
    @Column(name = "numero", nullable = false, unique = false, length = 5)
    private Integer numero;
    @Column(name = "complemento", nullable = true, unique = false)
    private String complemento;

    @OneToOne
    @JsonIgnore
    private Usuario usuario;

    public Endereco(Integer cep, String estado, String cidade, String bairro, String rua, Integer numero) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }
}
