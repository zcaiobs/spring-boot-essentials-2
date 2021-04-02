package com.boot.spring.essentials.repository;

import com.boot.spring.essentials.domain.Anime;
import com.boot.spring.essentials.util.AnimeCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Test for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persists anime when successful")
    void saveTest(){
        Anime animeSaved = animeRepository.save(AnimeCreator.createAnime());
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(AnimeCreator.createValidAnime().getName());
    }
}