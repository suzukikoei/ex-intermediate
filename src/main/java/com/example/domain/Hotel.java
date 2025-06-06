package com.example.domain;

/**
 * ホテルドメイン.
 */
public class Hotel {
    /** ホテルID */
    private Integer id;
    /** 地域種別（首都圏など）　*/
    private String areaName;
    /** ホテル名 */
    private String hotelName;
    /** 所在地　*/
    private String address;
    /** 最寄り駅 */
    private String nearestStation;
    /** 価格　*/
    private Integer price;
    /** 駐車場有無　*/
    private String parking;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                ", nearestStation='" + nearestStation + '\'' +
                ", price=" + price +
                ", parking='" + parking + '\'' +
                '}';
    }
}
