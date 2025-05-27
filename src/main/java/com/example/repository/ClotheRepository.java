package com.example.repository;

import com.example.domain.Clothe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 衣類の情報を操作するリポジトリ.
 */
@Repository
public class ClotheRepository {
    private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER =
        (rs, i) ->{
        Clothe clothe = new Clothe();
        clothe.setId(rs.getInt("id"));
        clothe.setCategory(rs.getString("category"));
        clothe.setGenre(rs.getString("genre"));
        clothe.setGender(rs.getInt("gender"));
        clothe.setColor(rs.getString("color"));
        clothe.setPrice(rs.getInt("price"));
        clothe.setSize(rs.getString("size"));
        return clothe;
        };
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 性別と色で衣類を検索する.
     *
     * @param gender 性別
     * @param color　色
     * @return
     */
    public List<Clothe> findByColorAndGender(String color, Integer gender){
        String sql = "SELECT" +
                "  id" +
                ", category" +
                ", genre" +
                ", gender" +
                ", color" +
                ", price" +
                ", size" +
                " FROM clothes WHERE gender = :gender AND color = :color ORDER BY price";
        SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
        return template.query(sql, param, CLOTHE_ROW_MAPPER);
    }
    
}
