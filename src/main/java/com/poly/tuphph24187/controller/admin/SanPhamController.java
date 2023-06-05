package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.SanPhamViewModel;
import com.poly.tuphph24187.entity.admin.SanPham;
import com.poly.tuphph24187.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/san-pham/")
public class SanPhamController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping("hien-thi")
    public String hienThiSanPham(Model model) {
        List<SanPham> sanPhams = sanPhamRepository.findAll();
        model.addAttribute("sanPhams", sanPhams);
        return "admin/san_pham/san-pham";
    }

    @GetMapping("view-add")
    public String viewAddSanPham(
            Model model,
            @Validated @ModelAttribute("sanPhamViewModel")SanPhamViewModel sanPhamViewModel,
            BindingResult bindResult
    ) {
        System.out.println( bindResult.hasErrors() );
        if (bindResult.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/san_pham/add-san-pham";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdateSanPham(
            @PathVariable("id") UUID id, Model model,
            @Validated @ModelAttribute("sanPhamViewModel")SanPhamViewModel sanPhamViewModel,
            BindingResult bindResult
    ) {
        if (bindResult.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        SanPham sanPham = sanPhamRepository.findById(id).get();
        model.addAttribute("sanPham", sanPham);
        return "admin/san_pham/update-san-pham";
    }

    @GetMapping("delete/{id}")
    public String deleteSanPham(@PathVariable("id") UUID id, Model model) {
        SanPham sanPham = sanPhamRepository.findById(id).get();
        sanPhamRepository.delete(sanPham);
        List<SanPham> sanPhams = sanPhamRepository.findAll();
        model.addAttribute("sanPhams", sanPhams);
        return "admin/san_pham/san-pham";
    }

    @PostMapping("add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("tenSanPham") String tenSanPham,
            @Validated @ModelAttribute("sanPhamViewModel")SanPhamViewModel sanPhamViewModel,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            // Báo lỗi
            return "redirect:/san-pham/view-add";
        } else {
            // Thành công
            SanPham sanPham = new SanPham(ma,tenSanPham);
            sanPhamRepository.save(sanPham);
            return "redirect:/san-pham/hien-thi";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("tenSanPham") String tenSanPham,
                         @Validated @ModelAttribute("sanPhamViewModel")SanPhamViewModel sanPhamViewModel,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            return "redirect:/san-pham/view-update/{id}";
        } else {
            // Thành công
            SanPham sanPham = new SanPham(id,ma,tenSanPham);
            sanPhamRepository.save(sanPham);
            return "redirect:/san-pham/hien-thi";
        }
    }

}
