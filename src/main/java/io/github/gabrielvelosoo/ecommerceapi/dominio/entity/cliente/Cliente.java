package io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 15)
    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Carrinho carrinho;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}
