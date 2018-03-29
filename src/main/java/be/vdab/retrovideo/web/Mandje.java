package be.vdab.retrovideo.web;

import java.util.List;

public interface Mandje {
	void addFilmid(long filmid);
	List<Long> getFilmids();
	void deleteFilmids(long[] filmids);
}
