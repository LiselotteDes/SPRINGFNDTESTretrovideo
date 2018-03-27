package be.vdab.retrovideo.web;

import java.util.List;

public interface Mandje {
	void addFilm(long filmid);
	List<Long> getFilmids();
	void removeFilms(List<Long> filmids);
//	BigDecimal getTotaal();
}
