/**
 *
 * @author sensei
 */
public class Filmografia {
    private int id;
    private String titulo;
    private LocalDate fecha_estreno;
    private String sinopsis;
    private String clasificacion;
    private String pais;


    public filmografia() {
        super();
    }

    public Filmografia(int id, String titulo, LocalDate fecha_estreno, String sinopsis, String clasificacion, String pais) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_estreno = fecha_estreno;
        this.sinopsis = sinopsis;
        this.clasificacion = clasificacion;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Filmografia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha_estreno=" + fecha_estreno +
                ", sinopsis='" + sinopsis + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", pais='" + pais + '\'' +
                '}';
}