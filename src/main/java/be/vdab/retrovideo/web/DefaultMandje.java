package be.vdab.retrovideo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
class DefaultMandje implements Serializable, Mandje {
	private static final long serialVersionUID = 1L;
	private final List<Long> filmids = new ArrayList<>();
//	@NumberFormat(pattern = "0.00")
//	private BigDecimal totaal = BigDecimal.ZERO;
	@Override 
	public void addFilmid(long filmid) {
		filmids.add(filmid);
	}
	@Override
	public List<Long> getFilmids() {
		return filmids;
	}
	@Override
	public void deleteFilmids(long[] ids) {
//		filmids.removeAll(Arrays.asList(ids));
		for (long id: ids) {
			filmids.remove(id);
		}
	}
}
