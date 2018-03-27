package be.vdab.retrovideo.repositories;

import static org.junit.Assert.assertEquals;

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
@Import(JdbcGenreRepository.class)
public class JdbcGenreRepositoryTest {
	@Autowired
	private JdbcGenreRepository repository;
	@Autowired
	private NamedParameterJdbcTemplate template;
	private long voegGenreToe() {
		template.update("insert into genres(naam) values('integration test')", Collections.emptyMap());
		return template.queryForObject("select max(id) from genres", Collections.emptyMap(), Long.class);
	}
	@Test
	public void findAllGeeftAlleGenres() {
		voegGenreToe();
		long aantalGenres = template.queryForObject("select count(*) from genres", Collections.emptyMap(), Long.class);
		assertEquals(aantalGenres, repository.findAll().size());
	}

}
