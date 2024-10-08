package com.example.creatshop.repository;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:24 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.CategoryType;
import com.example.creatshop.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByType(CategoryType type);
    boolean existsByName(String name);
}
