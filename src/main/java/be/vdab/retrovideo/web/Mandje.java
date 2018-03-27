package be.vdab.retrovideo.web;

import java.util.List;

public interface Mandje {
	void addFilm(long filmid);
	public List<Long> getFilmids();
}
