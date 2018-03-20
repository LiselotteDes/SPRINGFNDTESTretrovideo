package be.vdab.retrovideo.entities;

public class Klant {
	private long id;
	private String familienaam;
	private String voornaam;
	private String straatNummer;
	private String postcode;
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
}
