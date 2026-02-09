package com.evendev.ediaebackend.daos;

import com.evendev.ediaebackend.utils.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseDao<Model, Id> {

    protected final Connection connection;

    protected BaseDao() {
        this(DBManager.connect());
    }

    protected BaseDao(Connection connection) {
        this.connection = connection;
    }

    protected abstract String getInsertSql();

    protected abstract String getUpdateSql();

    protected abstract String getDeleteSql();

    protected abstract String getSelectAllSql();

    protected abstract String getSelectByIdSql();

    protected abstract void bindInsert(PreparedStatement stmt, Model entity) throws SQLException;

    protected abstract void bindUpdate(PreparedStatement stmt, Model entity) throws SQLException;

    protected abstract void bindId(PreparedStatement stmt, Id id) throws SQLException;

    protected abstract Model mapRow(ResultSet rs) throws SQLException;

    public void insert(Model entity) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(getInsertSql())) {
            bindInsert(stmt, entity);
            stmt.executeUpdate();
        }
    }

    public void update(Model entity) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(getUpdateSql())) {
            bindUpdate(stmt, entity);
            stmt.executeUpdate();
        }
    }

    public void delete(Id id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(getDeleteSql())) {
            bindId(stmt, id);
            stmt.executeUpdate();
        }
    }

    public List<Model> findAll() throws SQLException {
        List<Model> results = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(getSelectAllSql());
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                results.add(mapRow(rs));
            }
        }
        return results;
    }

    public Optional<Model> findById(Id id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(getSelectByIdSql())) {
            // apply the id to the prepared statement
            // stmt.setInt(1, id); // this is an example, the actual implementation depends on the model
            bindId(stmt, id);
            try (ResultSet rs = stmt.executeQuery()) {
                // if because of the id, we expect at most one result, we can directly return an Optional<Model>
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }
}
