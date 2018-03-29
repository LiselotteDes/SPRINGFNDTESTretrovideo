package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.GenreService;

@Controller
@RequestMapping("genres")
class GenreController {
	private final GenreService genreService;
	private final FilmService filmService;
	private final Mandje mandje;
	private final static String GENRE_VIEW = "genre";
	private final static String FILM_VIEW = "film";
//	private final static String REDIRECT_NA_SUBMIT = "redirect:/mandje";
	GenreController(GenreService genreService, FilmService filmService, Mandje mandje) {
		this.genreService = genreService;
		this.filmService = filmService;
		this.mandje = mandje;
	}
	@GetMapping("{id}")
	ModelAndView genre(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(GENRE_VIEW);
		modelAndView.addObject("genres", genreService.findAll());
		modelAndView.addObject(genreService.findAll().get(Math.toIntExact(id)-1));
		modelAndView.addObject("films", filmService.findByGenre(id));
		return modelAndView;
	}
	@GetMapping("{genreid}/{filmid}")
	ModelAndView film(@PathVariable long filmid) {
		ModelAndView modelAndView = new ModelAndView(FILM_VIEW);
		filmService.read(filmid).ifPresent(film -> modelAndView.addObject(film));
		modelAndView.addObject(new MandjeForm(filmid));
		return modelAndView;
	}
//	@PostMapping("{genreid}/{filmid}")
//	String inMandje(MandjeForm form) {
//		mandje.addFilmid(form.getFilmid());
//		return REDIRECT_NA_SUBMIT;
//	}
}
