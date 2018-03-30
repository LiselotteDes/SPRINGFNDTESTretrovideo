package be.vdab.retrovideo.services;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.retrovideo.entities.Reservatie;
import be.vdab.retrovideo.repositories.FilmRepository;
import be.vdab.retrovideo.repositories.ReservatieRepository;

// Volgende annotaties: enkel in repository testen, of hier ook???
@RunWith(SpringRunner.class)
@SpringBootTest 
public class DefaultReservatieServiceTest {
	private ReservatieService reservatieService;
	@Autowired
	private FilmRepository dummyFilmRepository;
	@Autowired
	private ReservatieRepository dummyReservatieRepository;
	private Reservatie reservatie;
	@Before
	public void before() {
//		this.dummyFilmRepository = Mockito.mock(FilmRepository.class);
//		this.dummyReservatieRepository = Mockito.mock(ReservatieRepository.class);
		this.reservatieService = new DefaultReservatieService(dummyReservatieRepository, dummyFilmRepository);
	}
	@Test
	public void eenReservatieUpdatetDeFilm() {
//		reservatieService.create(reservatie);
	}

}
