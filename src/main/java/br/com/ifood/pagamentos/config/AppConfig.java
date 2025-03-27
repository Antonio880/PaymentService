package br.com.ifood.pagamentos.config;
import br.com.ifood.pagamentos.http.PedidoClient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PedidoClient pedidoClient() {
        return new PedidoClient();
    }
}
