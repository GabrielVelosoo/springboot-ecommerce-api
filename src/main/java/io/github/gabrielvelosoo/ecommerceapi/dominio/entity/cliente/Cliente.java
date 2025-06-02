package io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDateTime dataNascimento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Carrinho carrinho;

    public Cliente() {}
}
