package be.vdab.retrovideo.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Reservatie;
import be.vdab.retrovideo.repositories.ReservatieRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultReservatieService implements ReservatieService {
	private final ReservatieRepository reservatieRepository;
	DefaultReservatieService(ReservatieRepository reservatieRepository) {
		this.reservatieRepository = reservatieRepository;
	}
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Reservatie reservatie) {
		reservatieRepository.create(reservatie);
	}
}
