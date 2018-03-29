package be.vdab.retrovideo.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.services.FilmService;

@Controller
@RequestMapping("mandje")
class MandjeController {
	private final Mandje mandje;
	private final FilmService filmService;
	private static final String MANDJE_VIEW = "mandje";
	private static final String REDIRECT_NA_DELETE = "redirect:/mandje";
	MandjeController(Mandje mandje, FilmService filmService) {
		this.mandje = mandje;
		this.filmService = filmService;
	}
	private List<Film> maakFilmsVanIds(List<Long> filmids) {
		List<Film> films = new ArrayList<>(filmids.size());
		for (long id: filmids) {
			filmService.read(id).ifPresent(film -> films.add(film));
		}
		return films;
	}
	private BigDecimal getTotaal(List<Long> filmids) {
		List<Film> films = maakFilmsVanIds(filmids);
		return films.stream().map(film -> film.getPrijs()).reduce(BigDecimal.ZERO, (vorigeSom, prijs) -> vorigeSom.add(prijs));
	}
	@GetMapping
	ModelAndView toonMandje() {
		ModelAndView modelAndView = new ModelAndView(MANDJE_VIEW);
		modelAndView.addObject(new MandjeForm());
		modelAndView.addObject("filmsInMandje", maakFilmsVanIds(mandje.getFilmids()));
		modelAndView.addObject("totaal", getTotaal(mandje.getFilmids()));
		return modelAndView;
	}
//	@PostMapping
//	String voegFilmToeAanMandje(FilmForm form) {
//		mandje.addFilmid(form.getFilmid());
//		return REDIRECT_NA_TOEVOEGEN;
//	}
	private final static String REDIRECT_NA_SUBMIT = "redirect:/mandje";
	@PostMapping
	String inMandje(MandjeForm form) {
		mandje.addFilmid(form.getFilmid());
		return REDIRECT_NA_SUBMIT;
	}
	@PostMapping(value="verwijderen", params = "verwijderids")
	String delete(long[] verwijderids) {
		if (verwijderids != null) {
			mandje.deleteFilmids(verwijderids);
		}
		return REDIRECT_NA_DELETE;
	}
}
