package be.vdab.retrovideo.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.entities.Reservatie;
import be.vdab.retrovideo.exceptions.ReservatieException;
import be.vdab.retrovideo.repositories.FilmRepository;
import be.vdab.retrovideo.repositories.ReservatieRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultReservatieService implements ReservatieService {
	private final ReservatieRepository reservatieRepository;
	private final FilmRepository filmRepository;
	DefaultReservatieService(ReservatieRepository reservatieRepository, FilmRepository filmRepository) {
		this.reservatieRepository = reservatieRepository;
		this.filmRepository = filmRepository;
	}
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Reservatie reservatie) {
		Film film = filmRepository.read(reservatie.getFilmid()).get();
		if (film.getBeschikbaar() > 0) {
			reservatieRepository.create(reservatie);
			filmRepository.updateBijReservatie(film);
		}
		else {
			throw new ReservatieException("Geen film beschikbaar");
		}
	}
}
