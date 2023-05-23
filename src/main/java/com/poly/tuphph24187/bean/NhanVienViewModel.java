package com.poly.tuphph24187.bean;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NhanVienViewModel {

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String ma;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String ho;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String tenDem;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String ten;

    @NotNull
    private String gioiTinh;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String ngaySinh;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String email;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String sdt;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String password;

    @NotNull
    private String trangThai;


}
