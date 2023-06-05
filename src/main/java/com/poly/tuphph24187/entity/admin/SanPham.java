package com.poly.tuphph24187.entity.admin;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "san_pham")
public class SanPham {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String tenSanPham;

    public SanPham(String ma, String tenSanPham) {
        this.ma = ma;
        this.tenSanPham = tenSanPham;
    }
}
