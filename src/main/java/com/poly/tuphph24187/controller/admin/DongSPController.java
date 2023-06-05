package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.DongSPViewModel;
import com.poly.tuphph24187.entity.admin.DongSP;
import com.poly.tuphph24187.repository.DongSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/dong-sp/")
public class DongSPController {

    @Autowired
    private DongSPRepository dongSPRepository;

    @GetMapping("hien-thi")
    public String hienThiDongSP(Model model) {
        List<DongSP> dongSPS = dongSPRepository.findAll();
        model.addAttribute("dongSPS", dongSPS);
        return "admin/dong_sp/dong-sp";
    }

    @GetMapping("view-add")
    public String viewAddDongSP(
            Model model,
            @Validated @ModelAttribute("dongSPViewModel")DongSPViewModel dongSPViewModel,
            BindingResult result
    ) {
        System.out.println( result.hasErrors() );
        if (result.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/dong_sp/add-dong-sp";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdateDongSP(
            @PathVariable("id") UUID id, Model model,
            @Validated @ModelAttribute("dongSPViewModel")DongSPViewModel dongSPViewModel,
            BindingResult result
    ) {
        if (result.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        DongSP dongSP = dongSPRepository.findById(id).get();
        model.addAttribute("dongSP", dongSP);
        return "admin/dong_sp/update-dong-sp";
    }

    @GetMapping("delete/{id}")
    public String deleteDongSP(@PathVariable("id") UUID id, Model model) {
        DongSP dongSP = dongSPRepository.findById(id).get();
        dongSPRepository.delete(dongSP);
        List<DongSP> dongSPS = dongSPRepository.findAll();
        model.addAttribute("dongSPS", dongSPS);
        return "admin/dong_sp/dong-sp";
    }

    @PostMapping("add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("tenDongSP") String tenDongSP,
            @Validated @ModelAttribute("dongSPViewModel")DongSPViewModel dongSPViewModel,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/dong-sp/view-add";
        } else {
            DongSP dongSP = new DongSP(ma,tenDongSP);
            dongSPRepository.save(dongSP);
            return "redirect:/dong-sp/hien-thi";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("tenDongSP") String tenDongSP,
                         @Validated @ModelAttribute("dongSPViewModel")DongSPViewModel dongSPViewModel,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/dong-sp/view-update/{id}";
        } else {
            DongSP dongSP = new DongSP(id,ma,tenDongSP);
            dongSPRepository.save(dongSP);
            return "redirect:/dong-sp/hien-thi";
        }
    }

}
