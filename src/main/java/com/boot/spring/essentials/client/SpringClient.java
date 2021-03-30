package com.boot.spring.essentials.client;

import com.boot.spring.essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity1 = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}",
                Anime.class, 5);
        log.info(entity1);

        ResponseEntity<Anime> entity2 = new RestTemplate().postForEntity("http://localhost:8080/animes",
                Anime.builder().name("Death Note").build(), Anime.class);
        log.info(entity2);

        ResponseEntity<List<Anime>> entity3 =  new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<>(){});
        log.info(entity3);

        Anime anime1 = Anime.builder().name("X-Men").build();
        ResponseEntity<Anime> entity4 =  new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.POST,
                new HttpEntity<>(anime1, createHeaders()),
                Anime.class);
        log.info("saved anime {}", entity4);

        Anime anime2 = entity4.getBody();
        ResponseEntity<Void> entity5 =  new RestTemplate().exchange("http://localhost:8080/animes",
                HttpMethod.PUT,
                new HttpEntity<>(anime2, createHeaders()),
                Void.class);
        log.info(entity5);

        assert anime2 != null;
        ResponseEntity<Void> entity6 =  new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                HttpMethod.DELETE,
                new HttpEntity<>(createHeaders()),
                Void.class,
                anime2.getId());
        log.info(entity6);
    }

    public static HttpHeaders createHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
