package com.example.creatshop.domain.entity;
/*
 * @author HongAnh
 * @created 05 / 11 / 2024 - 10:48 CH
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "orderDetail")
    List<OrderItem> items;

    @OneToOne(mappedBy = "orderDetail")
    @JoinColumn(name = "payment_id")
    PaymentDetail paymentDetail;

    Double total;

    @CreationTimestamp
    Timestamp createdAt;

    @UpdateTimestamp
    Timestamp updatedAt;

    public void addItem(OrderItem orderItem) {
        if (Objects.isNull(items)) {
            items = new ArrayList<>();
        }
        items.add(orderItem);
        orderItem.setOrderDetail(this);
    }
}
