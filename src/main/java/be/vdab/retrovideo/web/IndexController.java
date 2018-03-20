package be.vdab.retrovideo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.services.GenreService;

@Controller
@RequestMapping("/")
class IndexController {
	private final GenreService genreService;
	private final static String INDEX_VIEW = "index";
	IndexController(GenreService genreService) {
		this.genreService = genreService;
	}
	@GetMapping
	ModelAndView index() {
		return new ModelAndView(INDEX_VIEW)
				.addObject("genres", genreService.findAll());
	}
}
