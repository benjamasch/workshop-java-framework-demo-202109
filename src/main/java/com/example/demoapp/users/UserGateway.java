package com.example.demoapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class UserGateway {

    private final String apiHost;
    private final RestTemplate restTemplate;

    @Autowired
    public UserGateway(RestTemplateBuilder builder,
                       @Value("${external_api_url}") String apiHost) {
        this.restTemplate = builder.build();
        this.apiHost = apiHost;
    }

    public Optional<UserResponse> getUserById(int id) {
        String url = apiHost + "/users/" + id;
        try {
            UserResponse result
                    = restTemplate.getForObject(url, UserResponse.class);
            return Optional.ofNullable(result);
        }catch (RestClientException e) {
            return Optional.empty();
        }
    }

}
