package be.vdab.retrovideo.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Reservatie;

@Repository
class JdbcReservatieRepository implements ReservatieRepository {
	private final NamedParameterJdbcTemplate template;
	private final SimpleJdbcInsert insert;
	JdbcReservatieRepository(DataSource dataSource, NamedParameterJdbcTemplate template) {
		this.insert = new SimpleJdbcInsert(dataSource);
		insert.withTableName("reservaties");
		this.template = template;
	}
	@Override
	public 	void create(Reservatie reservatie) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("klantid", reservatie.getKlantid());
		kolomWaarden.put("filmid", reservatie.getFilmid());
		kolomWaarden.put("reservatieDatum", reservatie.getReservatieDatum());
		insert.execute(kolomWaarden);
	}
}
