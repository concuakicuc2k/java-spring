package com.poly.tuphph24187.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class KhachHangViewModel {


    @NotBlank(message = "Không được để trống mã!")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String ma;

    @NotBlank(message = "Không được để trống họ!")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String ho;

    @NotBlank(message = "Không được để trống tên đệm!")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String tenDem;

    @NotBlank(message = "Không được để trống tên!")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String ten;

    @NotBlank(message = "Không được để trống ngày sinh!")
    @NotNull(message = "Dữ liệu không hợp lệ!")
    private String ngaySinh;

    @NotBlank(message = "Không được để trống địa chỉ!")
    @Length(max = 100,message = ("Không quá 100 ký tự"))
    private String diaChi;

    @NotBlank(message = "Không được để trống số điện thoại!")
    @Length(max = 15,message = ("Số điện thoại quá dài"))
    private String sdt;

    @NotBlank(message = "Không được để trống mật khẩu!")
    @Length(max = 16,message = ("Không quá 16 ký tự"))
    private String password;

    private String thanhPho;

    private String quocGia;



}
