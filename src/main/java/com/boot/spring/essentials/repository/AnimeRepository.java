package com.boot.spring.essentials.repository;

import com.boot.spring.essentials.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository {
    List<Anime> listAll();
}
