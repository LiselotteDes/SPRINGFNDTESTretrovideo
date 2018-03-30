package be.vdab.retrovideo.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Reservatie implements Serializable {
	private final static long serialVersionUID = 1L;
	@NotNull
	private long klantid;
	@NotNull
	private long filmid;
	@NotNull @DateTimeFormat(style = "S-")
	private LocalDateTime reservatieDatum = LocalDateTime.now();
	public Reservatie(long klantid, long filmid, LocalDateTime reservatieDatum) {
		this.klantid = klantid;
		this.filmid = filmid;
		this.reservatieDatum = reservatieDatum;
	}
	public Reservatie() {
	}
	public long getKlantid() {
		return klantid;
	}
	public void setKlantid(long klantid) {
		this.klantid = klantid;
	}
	public long getFilmid() {
		return filmid;
	}
	public void setFilmid(long filmid) {
		this.filmid = filmid;
	}
	public LocalDateTime getReservatieDatum() {
		return reservatieDatum;
	}
	public void setReservatieDatum(LocalDateTime reservatieDatum) {
		this.reservatieDatum = reservatieDatum;
	}
	
}
