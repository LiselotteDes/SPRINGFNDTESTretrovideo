package be.vdab.retrovideo.web;

class FilmForm {
	private long filmid;
	
	public FilmForm() {
	}

	public FilmForm(long filmid) {
		this.filmid = filmid;
	}

	public long getFilmid() {
		return filmid;
	}

	public void setFilmid(long filmid) {
		this.filmid = filmid;
	}
	
}
