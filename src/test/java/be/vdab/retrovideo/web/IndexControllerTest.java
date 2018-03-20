package be.vdab.retrovideo.web;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.GenreService;

public class IndexControllerTest {
	private GenreService dummyGenreService;
	private IndexController controller;
	@Before
	public void before() {
		dummyGenreService = Mockito.mock(GenreService.class);
		controller = new IndexController(dummyGenreService);
	}
	@Test
	public void indexWerktSamenMetDeJuisteJSP() {
		ModelAndView modelAndView = controller.index();
		assertEquals("index", modelAndView.getViewName());
	}
	@Test
	public void indexGeeftGenresAanJSP() {
		ModelAndView modelAndView = controller.index();
		assertTrue(modelAndView.getModel().containsKey("genres"));
	}
}
