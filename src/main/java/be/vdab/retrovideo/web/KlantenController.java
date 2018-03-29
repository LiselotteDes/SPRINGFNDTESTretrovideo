package be.vdab.retrovideo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.services.KlantService;

@Controller
@RequestMapping("klanten")
class KlantenController {
	private final KlantService klantService;
	private final Mandje mandje;
//	private final IdentificatieKlant identificatieKlant;
	private final static String FAMILIENAAM_BEVAT_VIEW = "familienaambevat";
	private final static String BEVESTIGEN_VIEW = "bevestigen";
	private final static String REDIRECT_NA_BEVESTIGEN = "redirect:rapport";
	private final static String RAPPORT_VIEW = "rapport";
	KlantenController(KlantService klantService, Mandje mandje) {
		this.klantService = klantService;
		this.mandje = mandje;
//		this.identificatieKlant = identificatieKlant;
	}
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
	@GetMapping("{id}")
	ModelAndView identificatieKlant(@PathVariable long id) {
//		identificatieKlant.setKlantid(id);
		ModelAndView modelAndView = new ModelAndView(BEVESTIGEN_VIEW);
		klantService.read(id).ifPresent(klant -> modelAndView.addObject(klant));
		modelAndView.addObject("aantalFilms", mandje.getFilmids().size());
		return modelAndView;
	}
	@PostMapping("{id}")
	ModelAndView bevestigen(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(REDIRECT_NA_BEVESTIGEN);
		return modelAndView;
	}
	@GetMapping("{id}/rapport")
	ModelAndView rapport() {
		ModelAndView modelAndView = new ModelAndView(RAPPORT_VIEW);
		return modelAndView;
	}
}
