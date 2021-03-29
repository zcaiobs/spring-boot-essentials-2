package com.boot.spring.essentials.client;

import com.boot.spring.essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
    }
}
