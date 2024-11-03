package com.example.creatshop.domain.entity;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 9:02 AM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.exception.NotFoundException;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Double price;

    @Column(nullable = false)
    String imageStaticUrl;

    @Column(nullable = false)
    String imageDynamicUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "product")
    List<ProductVariant> productVariants;

    @CreationTimestamp
    Timestamp createdAt;

    @UpdateTimestamp
    Timestamp updatedAt;

    public void addCategory(Category category) {
        if (Objects.isNull(category)) {
            throw new NotFoundException(ErrorMessage.Common.NOT_FOUND_CATEGORY);
        }
        category.getProducts().add(this);
        this.setCategory(category);
    }
}
