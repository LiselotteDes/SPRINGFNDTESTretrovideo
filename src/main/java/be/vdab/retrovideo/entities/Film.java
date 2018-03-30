package be.vdab.retrovideo.entities;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

public class Film {
	private long id;
	private long genreid;
	private String titel;
	private long voorraad;
	private long gereserveerd;
	@NumberFormat(pattern = "0.00")
	private BigDecimal prijs;
	public Film(long id, long genreid, String titel, long voorraad, long gereserveerd, BigDecimal prijs) {
		this.id = id;
		this.genreid = genreid;
		this.titel = titel;
		this.voorraad = voorraad;
		this.gereserveerd = gereserveerd;
		this.prijs = prijs;
	}
	public Film() {
	}
	public long getId() {
		return id;
	}
	public long getGenreid() {
		return genreid;
	}
	public String getTitel() {
		return titel;
	}
	public long getVoorraad() {
		return voorraad;
	}
	public long getGereserveerd() {
		return gereserveerd;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public long getBeschikbaar() {
		long beschikbaar = 0L;
		if (voorraad - gereserveerd > 0) {
			beschikbaar = voorraad - gereserveerd;
		}
		return beschikbaar;
	}
	
}
