package be.vdab.retrovideo.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Film;

public interface FilmRepository {
	Optional<Film> read(long id);
	void updateBijReservatie(Film film);
	List<Film> findByGenre(long genreid);
}
