package br.dev.lukazrocha.totalshakepagamentoAPI.dto.request;

import br.dev.lukazrocha.totalshakepagamentoAPI.enums.FormaDePagamento;
import br.dev.lukazrocha.totalshakepagamentoAPI.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PagamentoDTORequest {

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @NotBlank
    @Max(100)
    private String nome;

    @NotNull
    @NotBlank
    @Max(100)
    private String numero;

    @NotNull
    private String expiracao;

    @NotNull
    @NotBlank
    @Min(3)
    @Max(3)
    private String codigo;

    @NotNull
    private Status status;

    @NotNull
    private Long pedidoId;

    @NotNull
    private FormaDePagamento formaDePagamento;

}
