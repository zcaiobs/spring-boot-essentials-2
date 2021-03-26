package com.boot.spring.essentials.mapper;

import com.boot.spring.essentials.request.AnimeRequestPost;
import com.boot.spring.essentials.domain.Anime;
import com.boot.spring.essentials.request.AnimeRequestPut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimeRequestPost animeRequestPost);
    public abstract Anime toAnime(AnimeRequestPut animeRequestPut);
}
