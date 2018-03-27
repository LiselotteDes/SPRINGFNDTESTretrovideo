package be.vdab.retrovideo.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE) 
@Import(JdbcKlantRepository.class)
public class JdbcKlantRepositoryTest {
	@Autowired
	private JdbcKlantRepository repository;
	@Autowired
	private NamedParameterJdbcTemplate template;
	private long voegKlantToe() {
		template.update("insert into klanten(familienaam, voornaam, straatNummer, postcode, gemeente) values('integration', 'test', '1', '8500', 'Kortrijk')", 
				Collections.emptyMap());
		return template.queryForObject("select max(id) from klanten", Collections.emptyMap(), Long.class);
	}
	@Test
	public void read() {
		long hoogsteId = voegKlantToe();
		assertEquals("integration", repository.read(hoogsteId).get().getFamilienaam());
	}
	@Test
	public void findByBeginFamilienaamGeeftJuisteKlanten() {
		voegKlantToe();
		repository.findByBeginFamilienaam("int").stream().forEach(klant -> assertTrue(klant.getFamilienaam().startsWith("int")));
	}
	@Test
	public void findByBeginFamilienaamGeeftJuisteAantalKlanten() {
		voegKlantToe();
		long aantalKlanten = template.queryForObject("select count(*) from klanten where familienaam like 'int%'", 
				Collections.emptyMap(), Long.class);
		assertEquals(aantalKlanten, repository.findByBeginFamilienaam("int").size());
	}
}
