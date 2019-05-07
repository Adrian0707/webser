package com.example.main.Dao;

import com.example.main.Entity.Zgloszenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;



@Repository("zgloszenieSql")
public class ZgloszenieDaoImpl implements ZgloszenieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class ZgloszenieRowMapper implements RowMapper<Zgloszenie> {

        @Override
        public Zgloszenie mapRow(ResultSet resultSet, int i) throws SQLException {
            Zgloszenie zgloszenie = new Zgloszenie(resultSet.getInt("id_zglosz"),
                    resultSet.getInt("id_uzyt"),resultSet.getInt("id_kategoria"),
                    resultSet.getInt("id_status"),resultSet.getInt("id_priorytet"),
                    resultSet.getString("opis"),resultSet.getString("obraz"),
                    resultSet.getDate("data_przyj"), resultSet.getDate("data_max"),
                    resultSet.getDate("data_real"),resultSet.getString("nazwa"));
            return zgloszenie;
        }
    }
    @Override
    public Collection<Zgloszenie> getAllZgloszenie() {
        // select column name from table name
        final String sql = "SELECT * FROM zgloszenia";
        return jdbcTemplate.query(sql, new ZgloszenieRowMapper());
    }
    @Override
    public Collection<Zgloszenie> getAllZgloszenie(int id_prac) {
        // select column name from table name
        final String sql = "SELECT * FROM system.zgloszenia where id_zglosz IN(SELECT id_zglosz FROM system.zadania_prac where id_prac=?)";
        return  jdbcTemplate.query(sql, new ZgloszenieRowMapper(),id_prac);

    }
    @Override
    public Zgloszenie getZgloszenieById(int id) {
        // select column name from table namw where column = value
        final String sql = "select * from zgloszenia where id_zglosz=?";
        return jdbcTemplate.queryForObject(sql, new ZgloszenieRowMapper(), id);
    }
    @Override
    public Collection<Zgloszenie> getZgloszeniaByIdUz(int idUz) {
        // select column name from table namw where column = value
        final String sql = "select * from zgloszenia where id_uzyt=?";
        return jdbcTemplate.query(sql, new ZgloszenieRowMapper(), idUz);
    }
    @Override
    public void upadeZgloszenieByID(Zgloszenie zgloszenie) {
        //upade table set column=value .... where column=value
        final String sql = "update zgloszenia set id_uzyt=?,id_kategoria=?, id_status=?," +
                "id_priorytet=?,opis=?,obraz=?,data_przyj=?,data_max=?,data_real=?,nazwa=? where id_zglosz=?";

        jdbcTemplate.update(sql, zgloszenie.getId_uzyt(),
                zgloszenie.getId_kategoria(),zgloszenie.getId_status(), zgloszenie.getId_priorytet(),
                zgloszenie.getOpis(),zgloszenie.getObraz(),zgloszenie.getData_przyj(),
                zgloszenie.getData_max(),zgloszenie.getData_real(),zgloszenie.getNazwa(),zgloszenie.getId_zglosz()
                );


    }

    @Override
    public void removeZgloszenieById(int id) {
//DELETE FROM NAME WHERE COLUMN = VALUE
        final String sql = " delete from zgloszenia where id_zglosz=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertZgloszenie(Zgloszenie zgloszenie) {
        //insert into table columns (...) values (...)
        final String sql = "insert into zgloszenia  Values (?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, zgloszenie.getId_zglosz(),
                zgloszenie.getOpis(),zgloszenie.getObraz(),
                zgloszenie.getData_przyj(),zgloszenie.getData_max(),
                zgloszenie.getData_real(),zgloszenie.getId_uzyt(),
                zgloszenie.getId_kategoria(),zgloszenie.getId_status(),
                zgloszenie.getId_priorytet(),zgloszenie.getNazwa());

    }
    @Override
    public int getZgloszenieCount() {
        final String sql = "SELECT max(id_zglosz) FROM system.zgloszenia;";
        Number count = jdbcTemplate.queryForObject(
                sql, Integer.class);
        return (count != null ? count.intValue() : 0);
    }

}
