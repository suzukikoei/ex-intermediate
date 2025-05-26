package com.example.form;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

/**
 * ホテルの金額入力フォーム
 */
public class HotelForm {
    /** ホテルの価格　*/
    @Range(min=0, max=1000000, message = "金額は0円以上100万円以下の整数を入力してください。")
    @Pattern(regexp = "^(0|[1-9]\\d{0,5}|1000000)$", message = "金額は整数で入力してください。")
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HotelForm{" +
                "price='" + price + '\'' +
                '}';
    }
}
