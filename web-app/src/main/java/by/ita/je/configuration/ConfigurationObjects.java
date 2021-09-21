package by.ita.je.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationObjects {
    @Bean
    public RestTemplate objectRestTemplate(){
        return new RestTemplate();
    }
}
