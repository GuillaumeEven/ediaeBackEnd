package com.evendev.ediaebackend.dao;

import com.evendev.ediaebackend.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmografiaDao {
        private Connection connection;
        private static final String INSERT = "INSERT INTO Filmografia (titulo, fecha_estreno, sinopsis, clasificacion_id, pais_id) VALUES (?)";
        private static final String UPDATE = "UPDATE Filmografia SET ? = ? WHERE id = ?";
        private static final String DELETE = "DELETE FROM Filmografia WHERE id = ?";
        private static final String LISTALL = "SELECT * FROM Filmografia";
        private static final String LISTONE = "SELECT * FROM Filmografia WHERE id = ?";

        public FilmografiaDao() {
                this.connection = DBManager.connect();
        }

        public void listAllFilmografia() throws SQLException {
        // TODO change it to use objects instead of just printing
                String sql = this.LISTALL;
                try {
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                                int id = rs.getInt("id");
                                String titulo = rs.getString("titulo");
                                System.out.println("Id: " + id + " --|-- Titulo: " + titulo);
                        }
                } catch (SQLException e) {
                        System.out.println(e);
                }

        }

        public void listAllFilmografiaWithFilter() throws SQLException {
            if (connection == null) {
                connection = DBManager.connect();
                if (connection == null) {
                    throw new SQLException("Connexion DB non initialisée (DBManager.connect() a retourné null)");
                }
            }
            String sql = "SELECT * FROM Filmografia WHERE id > ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, 0);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String titulo = rs.getString("titulo");
                        System.out.println("Id: " + id + " --|-- Titulo: " + titulo);
                    }
                }
            }
        }

        public void close() {
            DBManager.disconnect(connection);
            connection = null;
        }
}