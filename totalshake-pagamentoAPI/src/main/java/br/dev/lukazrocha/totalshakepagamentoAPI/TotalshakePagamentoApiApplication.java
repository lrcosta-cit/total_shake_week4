package br.dev.lukazrocha.totalshakepagamentoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TotalshakePagamentoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TotalshakePagamentoApiApplication.class, args);
	}

}
