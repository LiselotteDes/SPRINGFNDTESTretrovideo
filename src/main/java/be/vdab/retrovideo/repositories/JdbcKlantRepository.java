package be.vdab.retrovideo.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Klant;

@Repository
class JdbcKlantRepository implements KlantRepository {
	private final NamedParameterJdbcTemplate template;
	private final RowMapper<Klant> klantRowMapper = (resultSet, rowNum) -> new Klant(resultSet.getLong("id"), resultSet.getString("familienaam"),
			resultSet.getString("voornaam"), resultSet.getString("straatNummer"), resultSet.getString("postcode"), resultSet.getString("gemeente"));
	private static final String SQL_READ = "select id, familienaam, voornaam, straatNummer, postcode, gemeente from klanten where id = :id";
	private static final String SQL_SELECT_BY_IN_NAAM = "select * from klanten where familienaam like concat('%',:begin,'%') order by familienaam";
	JdbcKlantRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	@Override
	public Optional<Klant> read(long id) {
		try {
			return Optional.of(template.queryForObject(SQL_READ, Collections.singletonMap("id", id), klantRowMapper));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}
	@Override
	public List<Klant> findByInFamilienaam(String begin) {
		return template.query(SQL_SELECT_BY_IN_NAAM, Collections.singletonMap("begin", begin), klantRowMapper);
	}
}
