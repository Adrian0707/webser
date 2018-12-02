package com.example.main.Dao;

import com.example.main.Entity.Pracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("pracownikSql")
public class PracownikDaoImpl implements PracownikDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class PracownikRowMapper implements RowMapper<Pracownik> {

        @Override
        public Pracownik mapRow(ResultSet resultSet, int i) throws SQLException {
            Pracownik pracownik = new Pracownik();
            pracownik.setId(resultSet.getInt("id_prac"));
            pracownik.setImie(resultSet.getString("imie"));
            pracownik.setNazwisko(resultSet.getString("nazwisko"));
            pracownik.setEmail(resultSet.getString("email"));
            pracownik.setLogin(resultSet.getString("login"));
            pracownik.setHaslo(resultSet.getString("haslo"));
            return pracownik;
        }
    }

    @Override
    public Collection<Pracownik> getAllPracownik() {
        // select column name from table name
        final String sql = "SELECT id_prac, imie,nazwisko,email,login,haslo FROM pracownicy";
        List<Pracownik> pracownik = jdbcTemplate.query(sql, new PracownikRowMapper());
        return pracownik;
    }

    @Override
    public Pracownik getPracownikById(int id) {
        // select column name from table namw where column = value
        final String sql = "SELECT id_prac, imie,nazwisko,email,login,haslo FROM pracownicy where id_prac=?";
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, new PracownikRowMapper(), id);
        return pracownik;
    }

}
