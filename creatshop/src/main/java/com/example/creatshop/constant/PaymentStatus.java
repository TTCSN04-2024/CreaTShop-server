package com.example.creatshop.constant;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 11:01 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

public enum PaymentStatus {
    PENDING,    // Đang chờ thanh toán
    COMPLETED,  // Thanh toán thành công
    FAILED,     // Thanh toán thất bại
    CANCELED    // Thanh toán bị hủy
    ;
    public static final String VALID_STATUSES_REGEX = "^(PENDING|COMPLETED|FAILED|CANCELED)$";
}
