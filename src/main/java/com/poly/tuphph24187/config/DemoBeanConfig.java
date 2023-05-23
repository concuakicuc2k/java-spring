package com.poly.tuphph24187.config;

import com.poly.tuphph24187.bean.CuaHangViewModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBeanConfig {

    @Bean
    public CuaHangViewModel getCuaHangViewModel() {
        CuaHangViewModel cuaHangViewModel = new CuaHangViewModel();
        cuaHangViewModel.setMa("CH1");
        cuaHangViewModel.setTen("Cua Hang 1");
        cuaHangViewModel.setDiaChi("CAu Giay");

        return cuaHangViewModel;
    }

}
