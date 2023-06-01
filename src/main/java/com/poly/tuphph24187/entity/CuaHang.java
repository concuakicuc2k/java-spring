package com.poly.tuphph24187.entity;

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
@Table(name = "cua_hang")
public class CuaHang {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String tenCuaHang;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "quoc_gia")
    private String quocGia;

    public CuaHang(String ma, String tenCuaHang, String diaChi, String thanhPho, String quocGia) {
        this.ma = ma;
        this.tenCuaHang = tenCuaHang;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }
}
