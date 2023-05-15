package com.poly.tuphph24187.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name="KhachHang")
public class CuaHang {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    public CuaHang(String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }
}
