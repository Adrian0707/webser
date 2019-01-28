package com.example.main.Dao;


import com.example.main.Entity.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository("uzytkownikSql")
public class UzytkownikDaoImpl implements UzytkownikDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class UzytkownikRowMapper implements RowMapper<Uzytkownik> {

        @Override
        public Uzytkownik mapRow(ResultSet resultSet, int i) throws SQLException {
            Uzytkownik uzytkownik = new Uzytkownik(resultSet.getInt("id_uzyt"),
                    resultSet.getString("imie"), resultSet.getString("nazwisko"),
                    resultSet.getString("email"),resultSet.getString("login"),
                    resultSet.getString("haslo") );

            return uzytkownik;
        }
    }

    @Override
    public Collection<Uzytkownik> getAllUzytkownik() {
        // select column name from table name
        final String sql = "SELECT id_uzyt, imie,nazwisko,email,login,haslo FROM uzytkownicy";
        List<Uzytkownik> uzytkownik = jdbcTemplate.query(sql, new UzytkownikRowMapper());
        return uzytkownik;
    }

    @Override
    public Uzytkownik getUzytkownikById(int id) {
        // select column name from table namw where column = value
        final String sql = "SELECT id_uzyt, imie,nazwisko,email,login,haslo FROM uzytkownicy where id_uzyt=?";
        Uzytkownik uzytkownik = jdbcTemplate.queryForObject(sql, new UzytkownikRowMapper(), id);
        return uzytkownik;
    }

    @Override
    public int getUzytkownicyCount() {
        final String sql = "SELECT max(id_uzyt) FROM system.uzytkownicy;";
        Number count = jdbcTemplate.queryForObject(
                sql, Integer.class);
        return (count != null ? count.intValue() : 0);
    }

    @Override
    public  Uzytkownik getUzytkownikByLogHas(String login,String haslo){
        final String sql = "SELECT id_uzyt, imie,nazwisko,email,login,haslo FROM uzytkownicy where login=? and haslo=?";
        Uzytkownik uzytkownik = jdbcTemplate.queryForObject(sql, new UzytkownikRowMapper(), login,haslo);
        return uzytkownik;

    }
    @Override
    public  Uzytkownik getUzytkownikByLog(String login) {
        final String sql = "SELECT id_uzyt, imie,nazwisko,email,login,haslo FROM uzytkownicy where login=? ";
        Uzytkownik uzytkownik = jdbcTemplate.queryForObject(sql, new UzytkownikRowMapper(), login);
        return uzytkownik;
    }
    @Override
    public void upadeUzytkownikByID(Uzytkownik uzytkownik) {
        final String sql = "update uzytkownicy set imie=?,nazwisko=?,email=?,login=?,haslo=? where id_uzyt=?";

        jdbcTemplate.update(sql, uzytkownik.getImie(), uzytkownik.getNazwisko(), uzytkownik.getEmail(),
                uzytkownik.getLogin(), uzytkownik.getHaslo(),uzytkownik.getId_uzyt());

    }

    @Override
    public void removeUzytkownikById(int id) {
        final String sql = " delete from uzytkownicy where id_uzyt=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertUzytkownik(Uzytkownik uzytkownik) {
        final String sql = "insert into uzytkownicy (id_uzyt,imie,nazwisko,email,login,haslo) Values (?,?,?,?,?,?)";

        jdbcTemplate.update(sql, uzytkownik.getId_uzyt(), uzytkownik.getImie(), uzytkownik.getNazwisko(), uzytkownik.getEmail()
                ,uzytkownik.getLogin(),uzytkownik.getHaslo());

    }


}
