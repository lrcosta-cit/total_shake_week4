package br.dev.lukazrocha.totalshakepagamentoAPI.dto.response;

import br.dev.lukazrocha.totalshakepagamentoAPI.enums.FormaDePagamento;
import br.dev.lukazrocha.totalshakepagamentoAPI.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PagamentoDTOResponse {

    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long pedidoId;
    private FormaDePagamento formaDePagamento;

}
