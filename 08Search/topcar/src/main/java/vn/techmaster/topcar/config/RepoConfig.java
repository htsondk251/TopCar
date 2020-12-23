package vn.techmaster.topcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.techmaster.topcar.repository.CarDao;

@Configuration
public class RepoConfig {
    
    @Bean
    public CarDao carDao() {
        return new CarDao("topcar.csv");
    }
}
