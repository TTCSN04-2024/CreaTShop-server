package com.example.creatshop.repository;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:25 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.entity.Product;
import com.example.creatshop.domain.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Integer> {
    List<ProductVariant> findAllByProduct(Product product);
    void deleteAllByProduct(Product product);
}
