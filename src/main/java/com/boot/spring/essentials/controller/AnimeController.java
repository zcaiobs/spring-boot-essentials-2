package com.boot.spring.essentials.controller;

import com.boot.spring.essentials.domain.Anime;
import com.boot.spring.essentials.service.AnimeService;
import com.boot.spring.essentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public List<Anime> list() {
        log.info(dateUtil.formatLocaleDateTimeToDatabaseStyle(LocalDateTime.now()));
        return animeService.listAll();
    }
}
