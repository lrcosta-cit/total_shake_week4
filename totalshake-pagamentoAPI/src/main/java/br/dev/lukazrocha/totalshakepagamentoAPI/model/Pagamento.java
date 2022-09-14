package br.dev.lukazrocha.totalshakepagamentoAPI.model;

import br.dev.lukazrocha.totalshakepagamentoAPI.enums.FormaDePagamento;
import br.dev.lukazrocha.totalshakepagamentoAPI.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long pedidoId;
    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;


}
