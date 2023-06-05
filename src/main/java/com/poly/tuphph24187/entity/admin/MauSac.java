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
@Table(name = "mau_sac")
public class MauSac {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String tenMauSac;

    public MauSac(String ma, String tenMauSac) {
        this.ma = ma;
        this.tenMauSac = tenMauSac;
    }
}
