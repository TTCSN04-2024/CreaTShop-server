package com.example.creatshop.domain.dto.request;
/*
 * @author HongAnh
 * @created 04 / 11 / 2024 - 10:02 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AddressRequest {
    String firstName;
    String lastName;
    String country;
    String city;
    String district;
    String commune;
    String addressDetail;
    String description;
    String phoneNumber;
}
