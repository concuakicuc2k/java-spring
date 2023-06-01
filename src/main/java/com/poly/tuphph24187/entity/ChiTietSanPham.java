package com.poly.tuphph24187.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chitiet_sp")
public class ChiTietSanPham {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sp", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nsx", referencedColumnName = "id")
    private NSX nsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mausac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dongsp", referencedColumnName = "id")
    private DongSP dongSP;

    @Column(name = "nam_bh")
    private Integer namBH;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "so_luong_ton")
    private Integer soLuongTon;
    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;
    @Column(name = "gia_ban")
    private BigDecimal giaBan;


}
