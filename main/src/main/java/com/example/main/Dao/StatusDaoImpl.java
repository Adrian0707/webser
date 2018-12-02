package com.example.main.Dao;


import com.example.main.Entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("statusSql")
public class StatusDaoImpl implements StatusDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StatusRowMapper implements RowMapper<Status> {

        @Override
        public Status mapRow(ResultSet resultSet, int i) throws SQLException {
            Status status = new Status(resultSet.getInt("id_status"), resultSet.getString("nazwa"));
            return status;
        }
    }

    @Override
    public Collection<Status> getAllStatus() {
        // select column name from table name
        final String sql = "SELECT id_status, nazwa FROM status";
        List<Status> status = jdbcTemplate.query(sql, new StatusRowMapper());
        return status;
    }

    @Override
    public Status getStatusById(int id) {
        // select column name from table namw where column = value
        final String sql = "SELECT id_status, nazwa FROM status where id_status=?";
        Status status = jdbcTemplate.queryForObject(sql, new StatusRowMapper(), id);
        return status;
    }

}
