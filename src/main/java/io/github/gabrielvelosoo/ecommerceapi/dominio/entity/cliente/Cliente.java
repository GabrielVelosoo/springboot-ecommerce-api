package io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
public class Cliente extends Usuario {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String sobrenome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(length = 15)
    private String telefone;

    @Column(nullable = false, name = "dt_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Carrinho carrinho;

    public Cliente() {}
}
