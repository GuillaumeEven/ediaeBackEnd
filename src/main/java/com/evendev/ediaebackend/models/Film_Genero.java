public class Film_Genero {

    private int filmId;
    private int generoId;

    public Film_Genero(int filmId, int generoId) {
        this.filmId = filmId;
        this.generoId = generoId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    @Override
    public String toString() {
        return "Film_Genero{" + "filmId=" + filmId + ", generoId=" + generoId + '}';
    }

}
