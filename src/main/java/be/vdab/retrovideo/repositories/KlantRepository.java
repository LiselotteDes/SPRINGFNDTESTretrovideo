package be.vdab.retrovideo.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Klant;

public interface KlantRepository {
	Optional<Klant> read(long id);
	List<Klant> findByInFamilienaam(String begin);
}
