package com.example.creatshop.domain.entity;

import jakarta.persistence.*;
import lombok.*;

/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 9:09 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product_info")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String color;

    String size;

    Integer quantity;

    @ManyToOne
    Product product;
}