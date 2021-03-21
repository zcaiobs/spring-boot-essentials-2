package com.boot.spring.essentials.service;

import com.boot.spring.essentials.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    public List<Anime> listAll() {
        return List.of(new Anime(1L, "DBZ GT"), new Anime(2L, "Yu Yu Hakusho"));
    }
}
