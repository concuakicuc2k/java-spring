package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.KhachHangViewModel;
import com.poly.tuphph24187.entity.admin.KhachHang;
import com.poly.tuphph24187.entity.admin.NhanVien;
import com.poly.tuphph24187.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/khach-hang/")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("hien-thi")
    public String hienThiKhachHang(
            @RequestParam(defaultValue = "0", name = "page") int number, Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<KhachHang> khachHangs = khachHangRepository.findAll(pageable);
        model.addAttribute("khachHangs", khachHangs);
        return "admin/khach_hang/khach-hang";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model,
                          @Validated @ModelAttribute("khachHangViewModel") KhachHangViewModel khachHangViewModel,
                          BindingResult result
    ) {
        System.out.println( result.hasErrors() );
        if ( result.hasErrors() == true ) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/khach_hang/add-khach-hang";
    }

    @PostMapping("add")
    public String addKhachHang(Model model,
                              @RequestParam("ma") String ma, @RequestParam("ho") String ho,
                              @RequestParam("tenDem") String tenDem, @RequestParam("ten") String ten,
                              @RequestParam("ngaySinh") String ngaySinh, @RequestParam("sdt") String sdt,
                              @RequestParam("diaChi") String diaChi, @RequestParam("thanhPho") String thanhPho,
                              @RequestParam("quocGia") String quocGia, @RequestParam("password") String password,
                              @Validated @ModelAttribute("khachHangViewModel") KhachHangViewModel khachHangViewModel,
                              BindingResult result
    ) {
        if (result.hasErrors()) {
            return "admin/khach_hang/add-khach-hang";
        } else {
            KhachHang khachHang = KhachHang.builder()
                    .ma(ma)
                    .ho(ho)
                    .tenDem(tenDem)
                    .ten(ten)
                    .ngaySinh(ngaySinh)
                    .sdt(sdt)
                    .diaChi(diaChi)
                    .thanhPho(thanhPho)
                    .quocGia(quocGia)
                    .password(password)
                    .build();
            this.khachHangRepository.save(khachHang);
        }
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model,
                             @Validated @ModelAttribute("khachHangViewModel") KhachHangViewModel khachHangViewModel,
                             BindingResult result
    ) {
        System.out.println( result.hasErrors() );
        if ( result.hasErrors() == true ) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        KhachHang khachHang = khachHangRepository.findById(id).orElse(null);
        model.addAttribute("khachHang", khachHang);
        return "admin/khach_hang/update-khach-hang";
    }

    @PostMapping("update/{id}")
    public String updateKhachHang(Model model,
                                 @PathVariable("id") UUID id, @RequestParam("ma") String ma, @RequestParam("ho") String ho,
                                 @RequestParam("tenDem") String tenDem, @RequestParam("ten") String ten,
                                 @RequestParam("ngaySinh") String ngaySinh, @RequestParam("sdt") String sdt,
                                 @RequestParam("diaChi") String diaChi, @RequestParam("thanhPho") String thanhPho,
                                 @RequestParam("quocGia") String quocGia, @RequestParam("password") String password,
                                 @Validated @ModelAttribute("khachHangViewModel") KhachHangViewModel khachHangViewModel,
                                 BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/khach-hang/view-update/{id}";
        } else {
            KhachHang khachHang = new KhachHang(id,ma,ho,tenDem,ten,ngaySinh,sdt,diaChi,thanhPho,quocGia,password);
            this.khachHangRepository.save(khachHang);
        }
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        this.khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/hien-thi";
    }

}
