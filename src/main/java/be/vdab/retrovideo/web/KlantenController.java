package be.vdab.retrovideo.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.entities.Reservatie;
import be.vdab.retrovideo.exceptions.ReservatieException;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.KlantService;
import be.vdab.retrovideo.services.ReservatieService;

@Controller
@RequestMapping("klanten")
class KlantenController {
	private final KlantService klantService;
	private final ReservatieService reservatieService;
	private final FilmService filmService;
	private final Mandje mandje;
//	private final IdentificatieKlant identificatieKlant;
	KlantenController(KlantService klantService, ReservatieService reservatieService, FilmService filmService, Mandje mandje) {
		this.klantService = klantService;
		this.reservatieService = reservatieService;
		this.filmService = filmService;
		this.mandje = mandje;
//		this.identificatieKlant = identificatieKlant;
	}
	private final static String FAMILIENAAM_BEVAT_VIEW = "familienaambevat";
	@GetMapping
	ModelAndView familienaamBevat() {
		return new ModelAndView(FAMILIENAAM_BEVAT_VIEW).addObject(new FamilienaamBevatForm());
	}
	@GetMapping(params = "naambevat")
	ModelAndView familienaamBevat(@Valid FamilienaamBevatForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(FAMILIENAAM_BEVAT_VIEW);
		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		List<Klant> klanten = klantService.findByInFamilienaam(form.getNaambevat());
//		if (klanten.isEmpty()) {
//			bindingResult.reject("geenKlanten");
//		} else {
//			modelAndView.addObject("klanten", klanten);
//		}
		modelAndView.addObject("klanten", klanten);
		return modelAndView;
	}
	private final static String BEVESTIGEN_VIEW = "bevestigen";
	@GetMapping("{id}")
	ModelAndView identificatieKlant(@PathVariable long id) {
//		identificatieKlant.setKlantid(id);
		ModelAndView modelAndView = new ModelAndView(BEVESTIGEN_VIEW);
		klantService.read(id).ifPresent(klant -> modelAndView.addObject(klant));
		modelAndView.addObject("aantalFilms", mandje.getFilmids().size());
		return modelAndView;
	}
	private final static String REDIRECT_NA_BEVESTIGEN = "redirect:rapport";
	List<Film> mislukteReservaties = new ArrayList<>();
	@PostMapping("{id}")
	ModelAndView bevestigen(@PathVariable long id) {
		for (long filmid: mandje.getFilmids()) {
			Reservatie reservatie = new Reservatie();
			reservatie.setFilmid(filmid);
			reservatie.setKlantid(id);
			try {
				reservatieService.create(reservatie);
			} catch (ReservatieException ex) {
				mislukteReservaties.add(filmService.read(filmid).get());
			}
		}
		mandje.deleteFilmids(mandje.getFilmids().toArray());
		ModelAndView modelAndView = new ModelAndView(REDIRECT_NA_BEVESTIGEN);
		modelAndView.addObject("mislukteReservaties", mislukteReservaties);
		return modelAndView;
	}
//	private final static String RAPPORT_VIEW = "rapport";
//	@GetMapping("{id}/rapport")
//	ModelAndView rapport() {
//		ModelAndView modelAndView = new ModelAndView(RAPPORT_VIEW);
//		return modelAndView;
//	}
}
