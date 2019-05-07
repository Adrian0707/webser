package com.example.main.Dao;

import com.example.main.Entity.Kategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("kategoriaSql")
public class KategoriaDaoImpl implements KategoriaDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class KategoriaRowMapper implements RowMapper<Kategoria> {

        @Override
        public Kategoria mapRow(ResultSet resultSet, int i) throws SQLException {
            Kategoria kategoria = new Kategoria(resultSet.getInt("id_kategoria"), resultSet.getString("nazwa"));
            return kategoria;
        }
    }

    @Override
    public Collection<Kategoria> getAllKategoria() {
        // select column name from table name
        final String sql = "SELECT id_kategoria, nazwa FROM kategorie";
        List<Kategoria> kategoria = jdbcTemplate.query(sql, new KategoriaRowMapper());
        return kategoria;
    }

    @Override
    public Kategoria getKategoriaById(int id) {
        // select column name from table namw where column = value
        final String sql = "SELECT id_kategoria, nazwa FROM kategorie where id_kategoria=?";
        Kategoria kategoria = jdbcTemplate.queryForObject(sql, new KategoriaRowMapper(), id);
        return kategoria;
    }

}
