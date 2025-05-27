package com.example.repository;

import com.example.domain.Clothe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Clothe> findByGenderAndColor(Integer gender, String color){
        String sql = "SELECT" +
                "  id" +
                ", category" +
                ", genre" +
                ", gender" +
                ", color" +
                ", price" +
                ", size" +
                " FROM clothes WHERE gender = :gender AND color = :color ORDER BY price";
        SQL
        return template.query()
    }

}
