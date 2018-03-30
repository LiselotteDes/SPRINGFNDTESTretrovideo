package be.vdab.retrovideo.services;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.exceptions.ReservatieException;
import be.vdab.retrovideo.repositories.FilmRepository;

public class DefaultFilmServiceTest {
	private FilmRepository dummyFilmRepository;
	private FilmService filmService;
	private Film film = new Film(1, 1, "Test", 1, 1, BigDecimal.ONE);
	@Before
	public void before() {
		this.dummyFilmRepository = Mockito.mock(FilmRepository.class);
		this.filmService = new DefaultFilmService(dummyFilmRepository);
	}
	@Test(expected = ReservatieException.class)
	public void updateBijReservatieMisluktAlsBeschikbaarheid0Is() {
		filmService.updateBijReservatie(film);
	}

}
