package com.example.main.Dao;

import com.example.main.Entity.Komentarz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;


@Repository("komentarzSql")
public class KomentarzDaoImpl implements KomentarzDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class KomentarzRowMapper implements RowMapper<Komentarz> {

        @Override
        public Komentarz mapRow(ResultSet resultSet, int i) throws SQLException {
            Komentarz komentarz = new Komentarz(resultSet.getInt("id_komentarza"),
                    resultSet.getInt("id_prac"), resultSet.getInt("id_zglosz"),
                    resultSet.getString("comment"), resultSet.getDate("data"));
            return komentarz;
        }
    }
    @Override
    public Collection<Komentarz> getAllKomentarz() {
        // select column name from table name
        final String sql = "SELECT * FROM komentarze";
        return jdbcTemplate.query(sql, new KomentarzRowMapper());
    }
    @Override
    public Komentarz getKomentarzById(int id) {
        // select column name from table namw where column = value
        final String sql = "select * from komentarze where id_komentarza=?";
        return jdbcTemplate.queryForObject(sql, new KomentarzRowMapper(), id);
    }
    @Override
    public void upadeKomentarzByID(Komentarz komentarz) {
        //upade table set column=value .... where column=value
        final String sql = "update komentarze set id_prac=?,id_zglosz=?,comment=?, data=? where id_komentarza=?";
        int id_komentarza = komentarz.getId_komentarza();
        int id_prac = komentarz.getId_prac();
        int id_zglosz = komentarz.getId_zglosz();
        String comment = komentarz.getComment();
        Date data=komentarz.getData();
        jdbcTemplate.update(sql, id_prac, id_zglosz, comment,data, id_komentarza);


    }

    @Override
    public void removeKomentarzById(int id) {
//DELETE FROM NAME WHERE COLUMN = VALUE
        final String sql = " delete from komentarze where id_komentarza=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertKomentarz(Komentarz komentarz) {
        //insert into table columns (...) values (...)
        final String sql = "insert into komentarze (id_komentarza,id_prac,id_zglosz,comment,data) Values (?,?,?,?,?)";
        int id_komentarza = komentarz.getId_komentarza();
        int id_prac = komentarz.getId_prac();
        int id_zglosz = komentarz.getId_zglosz();
        String comment = komentarz.getComment();
        Date data=komentarz.getData();
        jdbcTemplate.update(sql, id_komentarza, id_prac, id_zglosz, comment,data);


    }
}
