package be.vdab.retrovideo.services;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.retrovideo.repositories.FilmRepository;
import be.vdab.retrovideo.repositories.ReservatieRepository;

// Volgende annotaties: enkel in repository testen, of hier ook???
@RunWith(SpringRunner.class)
@SpringBootTest 
public class DefaultReservatieServiceTest {
	private ReservatieService reservatieService;
	private FilmRepository dummyFilmRepository;
	private ReservatieRepository dummyReservatieRepository;
	@Before
	public void before() {
		this.dummyFilmRepository = Mockito.mock(FilmRepository.class);
		this.dummyReservatieRepository = Mockito.mock(ReservatieRepository.class);
	}
	@Test
	public void eenReservatieUpdatetDeFilm() {
		fail("Not yet implemented");
	}

}
