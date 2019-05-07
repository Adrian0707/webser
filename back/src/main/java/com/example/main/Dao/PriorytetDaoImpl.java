package com.example.main.Dao;

import com.example.main.Entity.Priorytet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("priorytetSql")
public class PriorytetDaoImpl implements PriorytetDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class PriorytetRowMapper implements RowMapper<Priorytet> {

        @Override
        public Priorytet mapRow(ResultSet resultSet, int i) throws SQLException {
            Priorytet priorytet = new Priorytet(resultSet.getInt("id_priorytet"), resultSet.getString("nazwa"));
            return priorytet;
        }
    }

    @Override
    public Collection<Priorytet> getAllPriorytet() {
        // select column name from table name
        final String sql = "SELECT id_priorytet, nazwa FROM priorytet";
        List<Priorytet> priorytet = jdbcTemplate.query(sql, new PriorytetRowMapper());
        return priorytet;
    }

    @Override
    public Priorytet getPriorytetById(int id) {
        // select column name from table namw where column = value
        final String sql = "SELECT id_priorytet, nazwa FROM priorytet where id_priorytet=?";
        Priorytet priorytet = jdbcTemplate.queryForObject(sql, new PriorytetRowMapper(), id);
        return priorytet;
    }

}
