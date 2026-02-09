package com.evendev.ediaebackend.daos;

import com.evendev.ediaebackend.models.Filmografia;
import com.evendev.ediaebackend.utils.DBManager;
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

        public FilmografiaDao(Connection connection) {
            this.connection = connection;
        }

        public void listAllFilmografia() throws SQLException {
                String sql = this.LISTALL;
                try {
                        PreparedStatement stmt = connection.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            Filmografia filmo = new Filmografia();
                            filmo.setid(rs.getInt("id"));
                            filmo.settitulo(rs.getString("titulo"));
                            filmo.setfecha_estreno(rs.getDate("fecha_estreno"));
                            filmo.setsinopsis(rs.getString("sinopsis"));
                            filmo.setpais(rs.getInt("pais_id"));
                            filmo.setclasificacion(rs.getInt("clasificacion_id"));
                            System.out.println(filmo.toString());
                        }
                } catch (SQLException e) {
                        System.out.println(e);
                }

        }

        public void listOne(int id) throws SQLException {
            String sql = this.LISTONE;
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Filmografia filmo = new Filmografia();
                    filmo.setid(rs.getInt("id"));
                    filmo.settitulo(rs.getString("titulo"));
                    filmo.setfecha_estreno(rs.getDate("fecha_estreno"));
                    filmo.setsinopsis(rs.getString("sinopsis"));
                    filmo.setpais(rs.getInt("pais_id"));
                    filmo.setclasificacion(rs.getInt("clasificacion_id"));
                    System.out.println(filmo.toString());
                } else {
                    System.out.println("No se encontró una filmografia con id: " + id);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
}