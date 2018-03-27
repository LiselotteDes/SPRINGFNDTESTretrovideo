package be.vdab.retrovideo.repositories;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.retrovideo.entities.Reservatie;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE) 
@Import(JdbcReservatieRepository.class)
public class JdbcReservatieRepositoryTest {
	@Autowired
	private JdbcReservatieRepository repository;
	@Autowired
	private NamedParameterJdbcTemplate template;
	@Test
	public void create() {
		Reservatie reservatie = new Reservatie();
		reservatie.setFilmid(1);
		reservatie.setKlantid(1);
		reservatie.setReservatieDatum(LocalDateTime.now());
		repository.create(reservatie);
		assertEquals(Integer.valueOf(1), template.queryForObject("select count(*) from reservaties where filmid=1 and klantid=1", 
				Collections.emptyMap(), Integer.class));
	}

}
