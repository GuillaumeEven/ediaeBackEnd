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

    private Connection connection;
    private static final String INSERT = "INSERT INTO pais (nombre) VALUES (?)";
    private static final String UPDATE = "UPDATE pais SET nombre = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM pais WHERE id = ?";
    private static final String SELECT_ALL = "SELECT id, nombre FROM pais";
    private static final String SELECT_BY_ID = "SELECT id, nombre FROM pais WHERE id = ?";

    public PaisDao() {
        this.connection = DBManager.connect();
    }

    public void insertPais(String nombre) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        }
    }

    public void updatePais(int id, String nombre) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void deletePais(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Pais> listAllPaises() throws SQLException {
        List<Pais> paises = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                Pais pais = new Pais(rs.getInt("id"), rs.getString("nombre"));
                paises.add(pais);
            }
        }
        return paises;
    }
}