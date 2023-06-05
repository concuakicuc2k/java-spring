package com.poly.tuphph24187.bean;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ChiTietSanPhamViewModel {


    private UUID sanPham;

    private UUID nsx;

    private UUID mauSac;

    private UUID dongSP;

    @NotBlank(message = "Không được để trống năm bảo hành")
    private String namBH;

    @NotBlank(message = "Không được để trống mô tả")
    private String moTa;

    @NotBlank(message = "Không được để trống số lượng tồn")
    private String soLuongTon;

    @NotBlank(message = "Không được để trống giá nhập")
    private String giaNhap;

    @NotBlank(message = "Không được để trống giá bán")
//    @DecimalMax(value = "100000000",message = "Giá bán quá lớn")
    private String giaBan;

}
