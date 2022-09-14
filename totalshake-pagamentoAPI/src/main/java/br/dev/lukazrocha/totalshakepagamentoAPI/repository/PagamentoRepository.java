package br.dev.lukazrocha.totalshakepagamentoAPI.repository;

import br.dev.lukazrocha.totalshakepagamentoAPI.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
