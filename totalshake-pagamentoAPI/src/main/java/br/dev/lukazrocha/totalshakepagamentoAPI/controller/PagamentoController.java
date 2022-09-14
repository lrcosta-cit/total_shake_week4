package br.dev.lukazrocha.totalshakepagamentoAPI.controller;

import br.dev.lukazrocha.totalshakepagamentoAPI.dto.request.PagamentoDTORequest;
import br.dev.lukazrocha.totalshakepagamentoAPI.dto.response.PagamentoDTOResponse;
import br.dev.lukazrocha.totalshakepagamentoAPI.integration.ConectPedido;
import br.dev.lukazrocha.totalshakepagamentoAPI.model.mapper.PagamentoMapper;
import br.dev.lukazrocha.totalshakepagamentoAPI.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/pagamentos")
public class PagamentoController<T> {

    @Autowired
    ConectPedido conectPedido;
    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private PagamentoMapper pagamentoMapper;

    /* TESTE PEDIDO (INTEGRAÇÃO) */
    @GetMapping("/pedidos")
    public ResponseEntity<List<?>> buscarPedidos(){
        return ResponseEntity.ok(conectPedido.getPedidos());
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<?> buscarPedidos(@PathVariable("id") Long id){
        return ResponseEntity.ok(conectPedido.getPedidobyId(id));
    }

    // PAGAMENTO //

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTOResponse> findPagamentoById(@PathVariable("id") Long id){
        return ResponseEntity.ok(pagamentoMapper.convertPagamentoToPagamentoDTOResponse(pagamentoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTOResponse>> findAllPagamentos(){
        return ResponseEntity.ok(pagamentoService.findAll()
                .stream()
                .map(p -> pagamentoMapper.convertPagamentoToPagamentoDTOResponse(p))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<PagamentoDTOResponse> createPagamento(@RequestBody PagamentoDTORequest pagamentoDTORequest){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pagamentoMapper.convertPagamentoToPagamentoDTOResponse(
                        pagamentoService.save(pagamentoMapper.convertPagamentoDTOResquestToPagamento(pagamentoDTORequest))));
    }


    @PatchMapping("/{id}/confirmar")
    public void confirmaPagamento(@PathVariable Long id){
        pagamentoService.confirmaPagamento(id);
    }



}
