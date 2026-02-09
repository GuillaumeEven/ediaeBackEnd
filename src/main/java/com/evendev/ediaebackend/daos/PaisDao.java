/*
 * Archivo generado por IA
*/

package com.evendev.ediaebackend.daos;

import com.evendev.ediaebackend.models.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDao extends BaseDao<Pais, Integer> {

    private static final String INSERT = "INSERT INTO pais (nombre) VALUES (?)";
    private static final String UPDATE = "UPDATE pais SET nombre = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM pais WHERE id = ?";
    private static final String SELECT_ALL = "SELECT id, nombre FROM pais";
    private static final String SELECT_BY_ID = "SELECT id, nombre FROM pais WHERE id = ?";

    public PaisDao() {
        super();
    }

    public PaisDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getInsertSql() {
        return INSERT;
    }

    @Override
    protected String getUpdateSql() {
        return UPDATE;
    }

    @Override
    protected String getDeleteSql() {
        return DELETE;
    }

    @Override
    protected String getSelectAllSql() {
        return SELECT_ALL;
    }

    @Override
    protected String getSelectByIdSql() {
        return SELECT_BY_ID;
    }

    @Override
    protected void bindInsert(PreparedStatement stmt, Pais entity) throws SQLException {
        stmt.setString(1, entity.getnombre());
    }

    @Override
    protected void bindUpdate(PreparedStatement stmt, Pais entity) throws SQLException {
        stmt.setString(1, entity.getnombre());
        stmt.setInt(2, entity.getid());
    }

    @Override
    protected void bindId(PreparedStatement stmt, Integer id) throws SQLException {
        stmt.setInt(1, id);
    }

    @Override
    protected Pais mapRow(ResultSet rs) throws SQLException {
        return new Pais(rs.getInt("id"), rs.getString("nombre"));
    }

    public void insertPais(String nombre) throws SQLException {
        insert(new Pais(0, nombre));
    }

    public void updatePais(int id, String nombre) throws SQLException {
        update(new Pais(id, nombre));
    }

    public void deletePais(int id) throws SQLException {
        delete(id);
    }

    public List<Pais> listAllPaises() throws SQLException {
        return new ArrayList<>(findAll());
    }
}