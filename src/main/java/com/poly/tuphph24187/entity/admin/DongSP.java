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
@Table(name = "dong_sp")
public class DongSP {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String tenDongSP;

    public DongSP(String ma, String tenDongSP) {
        this.ma = ma;
        this.tenDongSP = tenDongSP;
    }
}
