package be.vdab.retrovideo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.services.KlantService;

@Controller
@RequestMapping("klanten")
class KlantenController {
	private final KlantService klantService;
	private static final String FAMILIENAAM_BEVAT_VIEW = "familienaambevat";
	KlantenController(KlantService klantService) {
		this.klantService = klantService;
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
		List<Klant> klanten = klantService.findByBeginFamilienaam(form.getNaambevat());
		modelAndView.addObject("klanten", klanten);
		return modelAndView;
	}
}
