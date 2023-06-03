package com.poly.tuphph24187.bean;


import com.poly.tuphph24187.entity.ChucVu;
import com.poly.tuphph24187.entity.CuaHang;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NhanVienViewModel {

    @NotBlank(message = "Không được để trống")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String ma;

    @NotBlank(message = "Không được để trống")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String ho;

    private String tenDem;

    @NotBlank(message = "Không được để trống")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String ten;

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    @Pattern(regexp = "[01]", message = "Dữ liệu không hợp lệ!")
    private String gioiTinh = "1";

    @NotBlank(message = "Không được để trống!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    private String ngaySinh;

    @NotBlank(message = "Không được để trống")
    @Length(max = 100,message = ("Không quá 100 ký tự"))
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    @Length(max = 15,message = ("Số điện thoại quá dài"))
    private String sdt;

    @NotBlank(message = "Không được để trống")
    @Length(max = 16,message = ("Không quá 16 ký tự"))
    private String password;

    private String trangThai;

    private UUID chucVu;

    private UUID cuaHang;

}
