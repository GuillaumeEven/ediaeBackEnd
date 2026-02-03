public class Reparto {

    private int idReparto;
    private int idFilmografia;
    private String nombreActor;
    private String papel;

    public Reparto(int idReparto, int idFilmografia, String nombreActor, String papel) {
        this.idReparto = idReparto;
        this.idFilmografia = idFilmografia;
        this.nombreActor = nombreActor;
        this.papel = papel;
    }

    public int getIdReparto() {
        return idReparto;
    }

    public void setIdReparto(int idReparto) {
        this.idReparto = idReparto;
    }

    public int getIdFilmografia() {
        return idFilmografia;
    }

    public void setIdFilmografia(int idFilmografia) {
        this.idFilmografia = idFilmografia;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    @Override
    public String toString() {
        return "Reparto{" +
                "idReparto=" + idReparto +
                ", idFilmografia=" + idFilmografia +
                ", nombreActor='" + nombreActor + '\'' +
                ", papel='" + papel + '\'' +
                '}';
    }

}
