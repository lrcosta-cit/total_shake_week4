package br.dev.lukazrocha.totalshakepagamentoAPI.model.mapper;


import br.dev.lukazrocha.totalshakepagamentoAPI.dto.request.PagamentoDTORequest;
import br.dev.lukazrocha.totalshakepagamentoAPI.dto.response.PagamentoDTOResponse;
import br.dev.lukazrocha.totalshakepagamentoAPI.model.Pagamento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PagamentoMapper {

    private final ModelMapper modelMapper;

    public PagamentoMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Pagamento convertPagamentoDTOResquestToPagamento(PagamentoDTORequest pagamentoDTORequest){
        return modelMapper.map(pagamentoDTORequest, Pagamento.class);
    }

    public PagamentoDTOResponse convertPagamentoToPagamentoDTOResponse(Pagamento pagamento){
        return modelMapper.map(pagamento, PagamentoDTOResponse.class);
    }


}
