package be.vdab.retrovideo.services;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Film;

public interface FilmService {
	Optional<Film> read(long id);
	void updateBijReservatie(Film film);
	List<Film> findByGenre(long genreid);
}
