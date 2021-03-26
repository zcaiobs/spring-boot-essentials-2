package com.boot.spring.essentials;

import com.boot.spring.essentials.request.AnimeRequestPut;
import com.boot.spring.essentials.domain.Anime;
import com.boot.spring.essentials.repository.AnimeRepository;
import com.boot.spring.essentials.service.AnimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EssentialsApplicationTests {

	@Autowired
	AnimeRepository animeRepository;
	@Autowired
	AnimeService animeService;

	@Test
	void saveTest() {
		Anime anime = new Anime();
		anime.setName("Dragon Ball Z");
		animeRepository.save(anime);
	}

	@Test
	void replaceTest() {
		AnimeRequestPut a = new AnimeRequestPut();
		a.setId(1);
		a.setName("Dragon Ball GT");
		Assertions.assertEquals(a.getId(),  animeService.replace(a).getId());
	}
}
