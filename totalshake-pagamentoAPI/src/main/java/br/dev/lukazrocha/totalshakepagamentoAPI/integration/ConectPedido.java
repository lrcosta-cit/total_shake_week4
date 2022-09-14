package br.dev.lukazrocha.totalshakepagamentoAPI.integration;

import br.dev.lukazrocha.totalshakepagamentoAPI.dto.response.PedidoDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "pedido", url = "http://localhost:8082/api/")
public interface ConectPedido {

    @RequestMapping(method = RequestMethod.GET, path = "/pedidos/{id}")
    PedidoDTOResponse getPedidobyId(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, path = "/pedidos")
    List<PedidoDTOResponse> getPedidos();

    @RequestMapping(method = RequestMethod.PUT, path = "/pedidos/{id}/pago")
    PedidoDTOResponse alteraStatusPedido(@PathVariable Long id);

}
