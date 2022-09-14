package br.dev.lukazrocha.totalshakepagamentoAPI.dto.request;

import br.com.desafio.totalshake.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDTORequest {

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    private Status status;

    private List<ItemPedidoDTORequest> itensPedidoList;

}
