package com.example.creatshop.domain.mapper;
/*
 * @author HongAnh
 * @created 23 / 09 / 2024 - 7:15 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.domain.dto.request.ProductRequest;
import com.example.creatshop.domain.dto.response.ProductResponse;
import com.example.creatshop.domain.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring",  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);

    @Mapping(target = "productVariants", ignore = true)
    Product toProduct(ProductRequest request);

    void updateProduct(ProductRequest request, @MappingTarget Product product);
}
