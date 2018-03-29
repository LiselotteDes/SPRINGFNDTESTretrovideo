package be.vdab.retrovideo.web;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
class DefaultIdentificatieKlant implements Serializable, IdentificatieKlant {
	private static final long serialVersionUID = 1L;
	private long klantid;
	@Override
	public long getKlantid() {
		return klantid;
	}
	@Override
	public void setKlantid(long klantid) {
		this.klantid = klantid;
	}
}
