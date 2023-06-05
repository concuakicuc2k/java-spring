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
    private int gioiTinh;
    @Column(name = "ngay_sinh")
    private String ngaySinh;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "mat_khau")
    private String password;
    @Column(name = "trang_thai")
    private int trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv", referencedColumnName = "id")
    private ChucVu chucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ch", referencedColumnName = "id")
    private CuaHang cuaHang;


}
