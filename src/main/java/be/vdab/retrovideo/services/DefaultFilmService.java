package be.vdab.retrovideo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.exceptions.ReservatieException;
import be.vdab.retrovideo.repositories.FilmRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultFilmService implements FilmService {
	private final FilmRepository filmRepository;
	DefaultFilmService(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}
	@Override
	public Optional<Film> read(long id) {
		return filmRepository.read(id);
	}
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void updateBijReservatie(Film film) {
		if (film.getBeschikbaar() > 0) {
			filmRepository.updateBijReservatie(film);
		} else {
			throw new ReservatieException("Film is niet beschikbaar");
		}
	}
	@Override
	public List<Film> findByGenre(long genreid) {
		return filmRepository.findByGenre(genreid);
	}
	@Override
	public List<Film> findByIds(List<Long> ids) {
		return filmRepository.findByIds(ids);
	}

}
