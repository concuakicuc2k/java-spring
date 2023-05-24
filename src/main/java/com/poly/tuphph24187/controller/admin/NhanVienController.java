package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.NhanVienViewModel;
import com.poly.tuphph24187.entity.NhanVien;
import com.poly.tuphph24187.repository.NhanVienRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private NhanVienViewModel nhanVienViewModel;

    @GetMapping("hien-thi")
    public String hienThiNhanVien(Model model) {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        model.addAttribute("nhanViens", nhanViens);
        return "admin/nhan_vien/nhan-vien";
    }

    @GetMapping("view-add")
    public String viewAddNhanVien(
            @Validated @ModelAttribute("nhanVienViewModel") NhanVienViewModel nhanVienViewModel,
            BindingResult result
    ) {
        System.out.println( result.hasErrors() );
        if (result.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/nhan_vien/add-nhan-vien";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateNhanVien(
            @PathVariable("id") UUID id, Model model,
            @Validated @ModelAttribute("nhanVienViewModel") NhanVienViewModel nhanVienViewModel,
            BindingResult bindResult
    ) {
        if (bindResult.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        NhanVien nhanVien = nhanVienRepository.findById(id).get();
        model.addAttribute("nhanVien", nhanVien);
        return "admin/nhan_vien/update-nhan-vien";
    }

    @GetMapping("delete/{id}")
    public String deleteCuaHang(@PathVariable("id") UUID id, Model model) {
        NhanVien nhanVien = nhanVienRepository.findById(id).get();
        nhanVienRepository.delete(nhanVien);
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        model.addAttribute("nhanViens", nhanViens);
        return "admin/nhan_vien/nhan-vien";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ho") String ho,
                      @RequestParam("tenDem") String tenDem,
                      @RequestParam("ten") String ten,
                      @RequestParam("email") String email,
                      @RequestParam("ngaySinh") String ngaySinh,
                      @RequestParam("sdt") String sdt,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("password") String password,
                      @RequestParam("gioiTinh") int gioiTinh,
                      @RequestParam("trangThai") int trangThai,
                      @Valid @ModelAttribute("nhanVienViewModel") NhanVienViewModel nhanVienViewModel,
                      BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            return "redirect:/nhan-vien/view-add";
        } else {
            // Thành công
            NhanVien nhanVien = new NhanVien(ma ,ho ,tenDem ,ten,gioiTinh ,ngaySinh ,diaChi ,
                    email,sdt  ,password  ,trangThai );
            nhanVienRepository.save(nhanVien);
            return "redirect:/nhan-vien/hien-thi";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("ho") String ho,
                         @RequestParam("tenDem") String tenDem,
                         @RequestParam("ten") String ten,
                         @RequestParam("email") String email,
                         @RequestParam("ngaySinh") String ngaySinh,
                         @RequestParam("sdt") String sdt,
                         @RequestParam("diaChi") String diaChi,
                         @RequestParam("password") String password,
                         @RequestParam("gioiTinh") int gioiTinh,
                         @RequestParam("trangThai") int trangThai,
                         @Valid @ModelAttribute("nhanVienViewModel") NhanVienViewModel nhanVienViewModel,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            return "redirect:/nhan-vien/view-update/{id}";
        } else {
            // Thành công
            NhanVien nhanVien = new NhanVien(id,ma ,ho ,tenDem ,ten,gioiTinh ,ngaySinh ,diaChi ,
                    email,sdt  ,password  ,trangThai );
            nhanVienRepository.save(nhanVien);
            return "redirect:/nhan-vien/hien-thi";
        }

    }

}
