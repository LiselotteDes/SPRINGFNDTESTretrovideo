package be.vdab.retrovideo.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.NumberFormat;

public class Film implements Serializable {
	private final static long serialVersionUID = 1L;
	@NotNull
	private long id;
	@NotNull
	private long genreid;
	@NotNull
	private String titel;
	@NotNull @PositiveOrZero
	private long voorraad;
	@NotNull @PositiveOrZero
	private long gereserveerd;
	@NotNull
	@Min(0) @Max(99)
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
	@PositiveOrZero
	public long getBeschikbaar() {
		long beschikbaar = 0L;
		if (voorraad - gereserveerd > 0) {
			beschikbaar = voorraad - gereserveerd;
		}
		return beschikbaar;
	}
	
}
