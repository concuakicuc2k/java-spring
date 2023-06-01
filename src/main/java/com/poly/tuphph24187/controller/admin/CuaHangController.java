package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.CuaHangViewModel;
import com.poly.tuphph24187.entity.CuaHang;
import com.poly.tuphph24187.repository.CuaHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cua-hang/")
public class CuaHangController {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @GetMapping("hien-thi")
    public String hienThiCuaHang(Model model) {
        List<CuaHang> cuaHangs = cuaHangRepository.findAll();
        model.addAttribute("cuaHangs", cuaHangs);
        return "admin/cua_hang/cua-hang";
    }

    @GetMapping("view-add")
    public String viewAddCuaHang(
            Model model,
            @Validated @ModelAttribute("cuaHangViewModel") CuaHangViewModel cuaHangViewModel,
            BindingResult bindResult
    ) {
        System.out.println( bindResult.hasErrors() );
        if (bindResult.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/cua_hang/add-cua-hang";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdateCuaHang(
            @PathVariable("id") UUID id, Model model,
            @Validated @ModelAttribute("cuaHangViewModel") CuaHangViewModel cuaHangViewModel,
            BindingResult bindResult
    ) {
        if (bindResult.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");

        }
        CuaHang cuaHang = cuaHangRepository.findById(id).get();
        model.addAttribute("cuaHang", cuaHang);
        return "admin/cua_hang/update-cua-hang";
    }

    @GetMapping("delete/{id}")
    public String deleteCuaHang(@PathVariable("id") UUID id, Model model) {
        CuaHang cuaHang = cuaHangRepository.findById(id).get();
        cuaHangRepository.delete(cuaHang);
        List<CuaHang> cuaHangs = cuaHangRepository.findAll();
        model.addAttribute("cuaHangs", cuaHangs);
        return "admin/cua_hang/cua-hang";
    }

    @PostMapping("add")
    public String add(
                      @RequestParam("ma") String ma,
                      @RequestParam("tenCuaHang") String tenCuaHang,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("thanhPho") String thanhPho,
                      @RequestParam("quocGia") String quocGia,
                      CuaHangViewModel cuaHangViewModel
    ) {


        CuaHang cuaHang = new CuaHang(ma,tenCuaHang,diaChi,thanhPho,quocGia);
        cuaHangRepository.save(cuaHang);
        return "redirect:/cua-hang/hien-thi";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("tenCuaHang") String tenCuaHang,
                         @RequestParam("diaChi") String diaChi,
                         @RequestParam("thanhPho") String thanhPho,
                         @RequestParam("quocGia") String quocGia,
                         @Validated @ModelAttribute("cuaHangViewModel") CuaHangViewModel cuaHangViewModel,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            return "redirect:/cua-hang/view-update/{id}";
        } else {
            // Thành công
            CuaHang cuaHang = new CuaHang(id,ma,tenCuaHang,diaChi,thanhPho,quocGia);
            cuaHangRepository.save(cuaHang);
            return "redirect:/cua-hang/hien-thi";
        }

    }


}
