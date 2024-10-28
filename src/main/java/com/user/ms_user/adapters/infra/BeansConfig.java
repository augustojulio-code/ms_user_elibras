package com.user.ms_user.adapters.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.user.ms_user.core.ports.ClientRepositoryPort;
import com.user.ms_user.core.ports.ClientServicePort;
import com.user.ms_user.core.service.ClientService;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ClientServicePort clientServicePort(ClientRepositoryPort clientRepositoryPort) {

        return new ClientService(clientRepositoryPort);
    }
}
