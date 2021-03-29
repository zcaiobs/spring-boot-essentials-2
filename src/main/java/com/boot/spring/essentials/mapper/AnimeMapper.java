package com.boot.spring.essentials.mapper;

import com.boot.spring.essentials.request.AnimeRequestPost;
import com.boot.spring.essentials.domain.Anime;
import com.boot.spring.essentials.request.AnimeRequestPut;

public abstract class AnimeMapper {
    public static Anime toAnime(AnimeRequestPost animeRequestPost) {
        if (animeRequestPost == null) {
            return null;
        }
        return Anime.builder()
                .name(animeRequestPost.getName())
                .build();
    }
    public static Anime toAnime(AnimeRequestPut animeRequestPut) {
        if (animeRequestPut == null) {
            return null;
        }
        return Anime.builder()
                .id(animeRequestPut.getId())
                .name(animeRequestPut.getName())
                .build();
    }
}
