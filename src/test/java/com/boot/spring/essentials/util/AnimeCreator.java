package com.boot.spring.essentials.util;

import com.boot.spring.essentials.domain.Anime;

public class AnimeCreator {
    public static Anime createAnime() {
        return Anime.builder()
                .name("Yu Yu Hakusho")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .id(1L)
                .name("Yu Yu Hakusho")
                .build();
    }

    public static Anime createValidUpdatedAnime() {
        return Anime.builder()
                .id(1L)
                .name("Yu-Gi-Ho")
                .build();
    }
}
