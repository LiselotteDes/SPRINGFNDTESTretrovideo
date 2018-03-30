package be.vdab.retrovideo.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Genre implements Serializable {
	private final static long serialVersionUID = 1L;
	@NotNull
	private long id;
	@NotNull
	private String naam;
	public Genre(long id, String naam) {
		this.id = id;
		this.naam = naam;
	}
	public Genre() {
	}
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
}
