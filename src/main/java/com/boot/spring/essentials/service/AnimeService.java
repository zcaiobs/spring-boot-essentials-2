package com.boot.spring.essentials.service;

import com.boot.spring.essentials.exception.BadRequestException;
import com.boot.spring.essentials.mapper.AnimeMapper;
import com.boot.spring.essentials.request.AnimeRequestPost;
import com.boot.spring.essentials.request.AnimeRequestPut;
import com.boot.spring.essentials.domain.Anime;
import com.boot.spring.essentials.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimeService {

    AnimeRepository animeRepository;

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> listAllNonPageable() {
        return animeRepository.findAll();
    }

    public Anime findById(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    public Anime save(AnimeRequestPost anime) {
        return animeRepository.save(AnimeMapper.toAnime(anime));
    }

    public void deleteById(long id) {
        animeRepository.delete(findById(id));
    }

    public Anime replace(AnimeRequestPut anime) {
        if (animeRepository.existsById(anime.getId())) {
            return animeRepository.save(AnimeMapper.toAnime(anime));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found");
        }
    }
}