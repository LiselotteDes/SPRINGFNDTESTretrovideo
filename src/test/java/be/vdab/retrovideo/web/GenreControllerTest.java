package be.vdab.retrovideo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Genre;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.GenreService;

public class GenreControllerTest {
	private GenreController genreController;
	private GenreService dummyGenreService;
	private FilmService dummyFilmService;
	private Mandje dummyMandje;
	private List<Genre> genres;
	@Before
	public void before() {
		this.dummyFilmService = Mockito.mock(FilmService.class);
		this.dummyGenreService = Mockito.mock(GenreService.class);
		this.dummyMandje = Mockito.mock(Mandje.class);
		this.genres = new ArrayList<>();
		genres.add(new Genre(1, "Test"));
		Mockito.when(dummyGenreService.findAll()).thenReturn(genres);
		Mockito.when(dummyFilmService.read(1)).thenReturn(Optional.of(new Film(1, 1, "Test", 1, 0, BigDecimal.ONE)));
		this.genreController = new GenreController(dummyGenreService, dummyFilmService, dummyMandje);
	}
	@Test
	public void genreWerktSamenMetJuisteJSP() {
		ModelAndView modelAndView = genreController.genre(1);
		assertEquals("genre", modelAndView.getViewName());
	}
	@Test
	public void genreGeeftGenreAanJSP() {
		ModelAndView modelAndView = genreController.genre(1);
		assertTrue(modelAndView.getModel().containsKey("genre"));
	}
	@Test
	public void genreGeeftGenresAanJSP() {
		ModelAndView modelAndView = genreController.genre(1);
		assertTrue(modelAndView.getModel().containsKey("genres"));
	}
	@Test
	public void genreGeeftFilmsAanJSP() {
		ModelAndView modelAndView = genreController.genre(1);
		assertTrue(modelAndView.getModel().containsKey("films"));
	}
	@Test
	public void filmWerktSamenMetJuisteJSP() {
		ModelAndView modelAndView = genreController.film(1);
		assertEquals("film", modelAndView.getViewName());
	}
	@Test
	public void filmGeeftFilmAanJSP() {
		ModelAndView modelAndView = genreController.film(1);
		assertTrue(modelAndView.getModel().containsKey("film"));
	}
}
