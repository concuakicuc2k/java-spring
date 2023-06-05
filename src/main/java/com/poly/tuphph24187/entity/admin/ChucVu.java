package com.poly.tuphph24187.entity.admin;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chuc_vu")
public class ChucVu {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String tenChucVu;

    public ChucVu(String ma, String tenChucVu) {
        this.ma = ma;
        this.tenChucVu = tenChucVu;
    }
}
