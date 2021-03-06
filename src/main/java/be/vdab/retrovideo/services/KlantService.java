package be.vdab.retrovideo.services;

import java.util.List;
import java.util.Optional;

import be.vdab.retrovideo.entities.Klant;

public interface KlantService {
	Optional<Klant> read(long id);
	List<Klant> findByInFamilienaam(String begin);
}
