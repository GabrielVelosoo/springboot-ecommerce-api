package io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_item_carrinho")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ItemCarrinho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", precision = 18, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}
