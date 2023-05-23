package com.poly.tuphph24187.bean;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.UUID;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CuaHangViewModel {

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String ma;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String ten;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String diaChi;

    @NotNull
    private String thanhPho;

    @NotNull
    private String quocGia;

}
