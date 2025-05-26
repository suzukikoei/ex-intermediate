package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRepository {
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER =
            (rs, i) ->{
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName("hotel_name");
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));
        return hotel;
            };

    @Autowired
    NamedParameterJdbcTemplate template;

    /**
     * ホテル情報を全件検索する.
     * @return　ホテル情報一覧
     */
    public List<Hotel> findAll(){
        String sql = "SELECT id" +
                ", area_name" +
                ", hotel_name" +
                ", address" +
                ", nearest_station" +
                ", price" +
                ", parking" +
                " FROM hotels ORDER BY price DESC";
        return template.query(sql, HOTEL_ROW_MAPPER);
    }

    /**
     * ホテル情報を価格で絞り込み検索する.
     *
     * @param price ホテルの価格
     * @return ホテル情報一覧
     */
    public List<Hotel> findByPrice(Integer price){
        String sql = "SELECT id" +
                ", area_name" +
                ", hotel_name" +
                ", address" +
                ", nearest_station" +
                ", price" +
                ", parking" +
                " FROM hotels WHERE price <= :price ORDER BY price DESC";
        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
        return template.query(sql,param, HOTEL_ROW_MAPPER);
    }
}
