package be.vdab.retrovideo.web;

class MandjeForm {
	private long filmid;
	
	public MandjeForm() {
	}

	public MandjeForm(long filmid) {
		this.filmid = filmid;
	}

	public long getFilmid() {
		return filmid;
	}

	public void setFilmid(long filmid) {
		this.filmid = filmid;
	}
	
}
