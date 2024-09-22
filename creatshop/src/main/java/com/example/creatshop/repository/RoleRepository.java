package com.example.creatshop.repository;
/*
 * @author HongAnh
 * @created 22 / 09 / 2024 - 4:26 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.RoleType;
import com.example.creatshop.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByType(RoleType type);
    Optional<Role> findByType(RoleType type);
}
