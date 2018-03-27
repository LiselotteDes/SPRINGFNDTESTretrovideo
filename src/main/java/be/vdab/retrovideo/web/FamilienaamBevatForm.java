package be.vdab.retrovideo.web;

import javax.validation.constraints.NotBlank;

class FamilienaamBevatForm {
	@NotBlank
	private String naambevat;

	public String getNaambevat() {
		return naambevat;
	}

	public void setNaambevat(String naambevat) {
		this.naambevat = naambevat;
	}
	
}
