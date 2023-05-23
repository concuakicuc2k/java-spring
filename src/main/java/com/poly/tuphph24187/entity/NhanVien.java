package com.poly.tuphph24187.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
@Table(name = "nhan_vien")
public class NhanVien {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ho")
    private String ho;
    @Column(name = "ten_dem")
    private String tenDem;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gioi_tinh")
    private String gioiTinh;
    @Column(name = "ngay_sinh")
    private String ngaySinh;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "email")
    private String email;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "mat_khau")
    private String password;
    @Column(name = "trang_thai")
    private String trangThai;

    public NhanVien(String ma, String ho, String tenDem, String ten,
                    String gioiTinh, String ngaySinh, String diaChi,
                    String email, String sdt, String password, String trangThai) {
        this.ma = ma;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.password = password;
        this.trangThai = trangThai;
    }
}
