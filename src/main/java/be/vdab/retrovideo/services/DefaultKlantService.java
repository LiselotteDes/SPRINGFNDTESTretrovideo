package be.vdab.retrovideo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.repositories.KlantRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultKlantService implements KlantService {
	private final KlantRepository klantRepository;
	DefaultKlantService(KlantRepository klantRepository) {
		this.klantRepository = klantRepository;
	}
	@Override
	public Optional<Klant> read(long id) {
		return klantRepository.read(id);
	}
	@Override
	public List<Klant> findByInFamilienaam(String begin) {
		return klantRepository.findByInFamilienaam(begin);
	}
}
