package com.poly.tuphph24187.bean;

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
public class MauSacViewModel {

    @NotBlank(message = "Không được để trống")
    @Length(max = 30,message = ("Không quá 30 ký tự"))
    private String ma;

    @NotBlank(message = "Không được để trống")
    @Length(max = 255,message = ("Không quá 255 ký tự"))
    private String tenMauSac;

}
