package be.vdab.retrovideo.repositories;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.retrovideo.entities.Film;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE) 
@Import(JdbcFilmRepository.class)
public class JdbcFilmRepositoryTest {
	@Autowired
	private JdbcFilmRepository repository;
	@Autowired
	private NamedParameterJdbcTemplate template;
	private long voegFilmToe() {
		template.update("insert into films(genreid, titel, voorraad, gereserveerd, prijs) values(1, 'integration test', 3, 0, 3)", 
				Collections.emptyMap());
		return template.queryForObject("select max(id) from films", Collections.emptyMap(), Long.class);
	}
	@Test
	public void read() {
		long hoogsteId = voegFilmToe();
		assertEquals("integration test", repository.read(hoogsteId).get().getTitel());
	}
	@Test
	public void updateBijReservatie() {
		long hoogsteId = voegFilmToe();
		Film film = repository.read(hoogsteId).get();
		repository.updateBijReservatie(film);
		film = repository.read(hoogsteId).get();
		assertTrue(film.getGereserveerd() == 1);
	}
	@Test
	public void findByGenreGeeftJuisteFilms() {
		voegFilmToe();
		repository.findByGenre(1).stream().forEach(film -> assertEquals(1, film.getGenreid()));
	}
	@Test
	public void findByGenreGeeftJuisteAantalFilms() {
		voegFilmToe();
		long aantalFilms = template.queryForObject("select count(*) from films where genreid=1", Collections.emptyMap(), Long.class);
		assertEquals(aantalFilms, repository.findByGenre(1).size());
	}
}
