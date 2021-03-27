package com.boot.spring.essentials.mapper;

import com.boot.spring.essentials.request.AnimeRequestPost;
import com.boot.spring.essentials.domain.Anime;
import com.boot.spring.essentials.request.AnimeRequestPut;

public abstract class AnimeMapper {
    public static Anime toAnime(AnimeRequestPost animeRequestPost) {
        if (animeRequestPost == null) {
            return null;
        }
        return new Anime(
                animeRequestPost.getName()
        );
    }
    public static Anime toAnime(AnimeRequestPut animeRequestPut) {
        if (animeRequestPut == null) {
            return null;
        }
        return new Anime(
                animeRequestPut.getId(),
                animeRequestPut.getName()
        );
    }
}
