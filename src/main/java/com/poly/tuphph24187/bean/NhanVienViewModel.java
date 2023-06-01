package com.poly.tuphph24187.bean;


import com.poly.tuphph24187.entity.ChucVu;
import com.poly.tuphph24187.entity.CuaHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Getter
@Setter
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

    private String trangThai;

    private ChucVu chucVu;

    private CuaHang cuaHang;

}
