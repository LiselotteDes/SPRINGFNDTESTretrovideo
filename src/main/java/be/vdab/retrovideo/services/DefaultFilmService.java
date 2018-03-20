package be.vdab.retrovideo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
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
	public List<Film> findByGenre(long genreid) {
		return filmRepository.findByGenre(genreid);
	}
}
