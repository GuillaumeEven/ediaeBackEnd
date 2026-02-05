/*
 * Archivo generado por IA
*/

package com.evendev.ediaebackend.dao;

import com.evendev.ediaebackend.DBManager;
import com.evendev.ediaebackend.models.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaisDao {

    public List<Pais> findAll() {
        String sql = "SELECT id, nombre FROM pais";
        List<Pais> results = new ArrayList<>();

        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn != null ? conn.prepareStatement(sql) : null;
             ResultSet rs = stmt != null ? stmt.executeQuery() : null) {

            if (rs == null) {
                return results;
            }

            while (rs.next()) {
                results.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des pays");
            e.printStackTrace();
        }

        return results;
    }

    public Optional<Pais> findById(int id) {
        String sql = "SELECT id, nombre FROM pais WHERE id = ?";

        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn != null ? conn.prepareStatement(sql) : null) {

            if (stmt == null) {
                return Optional.empty();
            }

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement du pays id=" + id);
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public int insert(Pais pais) {
        String sql = "INSERT INTO pais (nombre) VALUES (?)";

        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn != null
                     ? conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
                     : null) {

            if (stmt == null) {
                return 0;
            }

            stmt.setString(1, pais.getnombre());
            int affected = stmt.executeUpdate();

            if (affected == 0) {
                return 0;
            }

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du pays");
            e.printStackTrace();
        }

        return 0;
    }

    public boolean update(Pais pais) {
        String sql = "UPDATE pais SET nombre = ? WHERE id = ?";

        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn != null ? conn.prepareStatement(sql) : null) {

            if (stmt == null) {
                return false;
            }

            stmt.setString(1, pais.getnombre());
            stmt.setInt(2, pais.getid());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du pays id=" + pais.getid());
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM pais WHERE id = ?";

        try (Connection conn = DBManager.connect();
             PreparedStatement stmt = conn != null ? conn.prepareStatement(sql) : null) {

            if (stmt == null) {
                return false;
            }

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du pays id=" + id);
            e.printStackTrace();
        }

        return false;
    }

    private Pais mapRow(ResultSet rs) throws SQLException {
        return new Pais(rs.getInt("id"), rs.getString("nombre"));
    }
}
