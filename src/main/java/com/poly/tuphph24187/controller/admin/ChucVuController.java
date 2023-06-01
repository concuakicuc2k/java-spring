package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.ChucVuViewModel;
import com.poly.tuphph24187.entity.ChucVu;
import com.poly.tuphph24187.repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chuc-vu/")
public class ChucVuController {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping("hien-thi")
    public String hienThiChucVu(Model model) {
        List<ChucVu> chucVus = chucVuRepository.findAll();
        model.addAttribute("chucVus", chucVus);
        return "admin/chuc_vu/chuc-vu";
    }

    @GetMapping("view-add")
    public String viewAddChucVu(
            Model model,
            @Validated @ModelAttribute("chucVuViewModel") ChucVuViewModel chucVuViewModel,
            BindingResult bindResult
    ) {
        System.out.println( bindResult.hasErrors() );
        if (bindResult.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/chuc_vu/add-chuc-vu";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdateChucVu(
            @PathVariable("id") UUID id, Model model,
            @Validated @ModelAttribute("chucVuViewModel") ChucVuViewModel chucVuViewModel,
            BindingResult bindResult
    ) {
        if (bindResult.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");

        }
        ChucVu chucVu = chucVuRepository.findById(id).get();
        model.addAttribute("chucVu", chucVu);
        return "admin/chuc_vu/update-chuc-vu";
    }

    @GetMapping("delete/{id}")
    public String deleteCuaHang(@PathVariable("id") UUID id, Model model) {
        ChucVu chucVu  = chucVuRepository.findById(id).get();
        chucVuRepository.delete(chucVu);
        List<ChucVu> chucVus = chucVuRepository.findAll();
        model.addAttribute("chucVus", chucVus);
        return "admin/chuc_vu/chuc-vu";
    }

    @PostMapping("add")
    public String add(
                      @RequestParam("ma") String ma,
                      @RequestParam("tenChucVu") String tenChucVu
    ) {


        ChucVu chucVu = new ChucVu(ma,tenChucVu);
        chucVuRepository.save(chucVu);
        return "redirect:/chuc-vu/hien-thi";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("tenChucVu") String tenChucVu,
                         @Validated @ModelAttribute("chucVuViewModel") ChucVuViewModel chucVuViewModel,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            return "redirect:/chuc-vu/view-update/{id}";
        } else {
            // Thành công
            ChucVu chucVu = new ChucVu(id,ma,tenChucVu);
            chucVuRepository.save(chucVu);
            return "redirect:/chuc-vu/hien-thi";
        }

    }


}
