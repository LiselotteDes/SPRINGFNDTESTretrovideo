package be.vdab.retrovideo.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Klant implements Serializable {
	private final static long serialVersionUID = 1L;
	@NotNull
	private long id;
	@NotNull
	private String familienaam;
	@NotNull
	private String voornaam;
	@NotNull
	private String straatNummer;
	@NotNull @Size(min=4,max=4)
	private String postcode;
	@NotNull
	private String gemeente;
	public Klant(long id, String familienaam, String voornaam, String straatNummer, String postcode, String gemeente) {
		this.id = id;
		this.familienaam = familienaam;
		this.voornaam = voornaam;
		this.straatNummer = straatNummer;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}
	public Klant() {
	}
	public long getId() {
		return id;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public String getStraatNummer() {
		return straatNummer;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getGemeente() {
		return gemeente;
	}
	public String getNaam() {
		return voornaam + ' ' + familienaam;
	}
}
