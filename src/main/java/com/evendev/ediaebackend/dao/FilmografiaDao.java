public class FilmografiaDao {
        private Connection connection;
        private static final String INSERT = "INSERT INTO filmografia (parametros) VALUES (?)";
        private static final String UPDATE = "UPDATE filmografia SET titulo = ? WHERE id = ?";
        private static final String DELETE = "DELETE FROM filmografia WHERE id = ?";
        private static final String SELECT_ALL = "SELECT * FROM filmografia";
        private static final String SELECT_BY_ID = "SELECT * FROM filmografia WHERE id = ?";
}
