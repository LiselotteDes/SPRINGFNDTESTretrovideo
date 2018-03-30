package be.vdab.retrovideo.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Film;

@Repository
class JdbcFilmRepository implements FilmRepository {
	private final NamedParameterJdbcTemplate template;
	private final RowMapper<Film> filmRowMapper = (resultSet, rowNum) -> new Film(resultSet.getLong("id"), resultSet.getLong("genreid"),
			resultSet.getString("titel"), resultSet.getLong("voorraad"), resultSet.getLong("gereserveerd"), resultSet.getBigDecimal("prijs"));
	private static final String SQL_READ = "select id, genreid, titel, voorraad, gereserveerd, prijs from films where id = :id";
	private static final String UPDATE_FILMS_BIJ_RESERVATIE = "update films set gereserveerd = gereserveerd+1 where id = :id";
	private static final String SELECT_BY_GENRE = "select id, genreid, titel, voorraad, gereserveerd, prijs from films where genreid = :genreid";
	
	JdbcFilmRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public Optional<Film> read(long id) {
		try {
			return Optional.of(template.queryForObject(SQL_READ, Collections.singletonMap("id", id), filmRowMapper));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}
	@Override
	public void updateBijReservatie(Film film) {
		template.update(UPDATE_FILMS_BIJ_RESERVATIE, Collections.singletonMap("id", film.getId()));
	}
	@Override
	public List<Film> findByGenre(long genreid) {
		return template.query(SELECT_BY_GENRE, Collections.singletonMap("genreid", genreid), filmRowMapper);
	}
}
