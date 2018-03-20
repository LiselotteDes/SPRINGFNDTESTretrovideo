package be.vdab.retrovideo.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reservatie implements Serializable {
	private final static long SerialVersionUID = 1L;
	private long klantid;
	private long filmid;
	private LocalDateTime reservatieDatum;
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
