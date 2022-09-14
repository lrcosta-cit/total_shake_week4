package br.dev.lukazrocha.totalshakepagamentoAPI.service;

import br.dev.lukazrocha.totalshakepagamentoAPI.enums.Status;
import br.dev.lukazrocha.totalshakepagamentoAPI.exceptions.PagamentoNotFoundException;
import br.dev.lukazrocha.totalshakepagamentoAPI.integration.ConectPedido;
import br.dev.lukazrocha.totalshakepagamentoAPI.model.Pagamento;
import br.dev.lukazrocha.totalshakepagamentoAPI.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    @Autowired
    ConectPedido conectPedido;

    public Pagamento findById(Long id){
        return repository.findById(id).orElseThrow(() -> new PagamentoNotFoundException("Pagamento não encontrado"));
    }

    public List<Pagamento> findAll(){
        return repository.findAll();
    }

    public Pagamento save(Pagamento pagamento){
        return repository.save(pagamento);
    }

    public Pagamento update(Long id, Pagamento pagamento){
        Pagamento pagamentoAtual = findById(id);

        pagamentoAtual.setFormaDePagamento(pagamento.getFormaDePagamento());
        pagamentoAtual.setStatus(pagamento.getStatus());
        pagamentoAtual.setNome(pagamento.getNome());
        pagamentoAtual.setCodigo(pagamento.getCodigo());
        pagamentoAtual.setExpiracao(pagamento.getExpiracao());
        pagamentoAtual.setNumero(pagamento.getNumero());
        pagamentoAtual.setValor(pagamento.getValor());

        return repository.save(pagamentoAtual);
    }

    public Pagamento updateStatus(Long id, Pagamento pagamento){
        Pagamento pagamentoAtual = findById(id);

        pagamentoAtual.setStatus(pagamento.getStatus());

        return repository.save(pagamentoAtual);
    }

    public void delete(Pagamento pagamento){
        repository.delete(pagamento);
    }

    public void confirmaPagamento(Long id){
        Pagamento pagamento = findById(id);

        pagamento.setStatus(Status.CONFIRMADO);
        save(pagamento);
        conectPedido.alteraStatusPedido(pagamento.getPedidoId()); // Manda Requisição para API de Pedido, trocando o status para PAGO
    }

}
