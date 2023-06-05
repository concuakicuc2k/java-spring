package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.MauSacViewModel;
import com.poly.tuphph24187.entity.admin.MauSac;
import com.poly.tuphph24187.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/mau-sac/")
public class MauSacController {

    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("hien-thi")
    public String hienThiMauSac(Model model) {
        List<MauSac> mauSacs = mauSacRepository.findAll();
        model.addAttribute("mauSacs", mauSacs);
        return "admin/mau_sac/mau-sac";
    }

    @GetMapping("view-add")
    public String viewAddMauSac(
            Model model,
            @Validated @ModelAttribute("mauSacViewModel") MauSacViewModel mauSacViewModel,
            BindingResult result
    ) {
        System.out.println( result.hasErrors() );
        if (result.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/mau_sac/add-mau-sac";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdateMauSac(
            @PathVariable("id") UUID id, Model model,
            @Validated @ModelAttribute("mauSacViewModel") MauSacViewModel mauSacViewModel,
            BindingResult result
    ) {
        if (result.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        MauSac mauSac = mauSacRepository.findById(id).get();
        model.addAttribute("mauSac", mauSac);
        return "admin/mau_sac/update-mau-sac";
    }

    @GetMapping("delete/{id}")
    public String deleteMauSac(@PathVariable("id") UUID id, Model model) {
        MauSac mauSac = mauSacRepository.findById(id).get();
        mauSacRepository.delete(mauSac);
        List<MauSac> mauSacs = mauSacRepository.findAll();
        model.addAttribute("mauSacs", mauSacs);
        return "admin/mau_sac/mau-sac";
    }

    @PostMapping("add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("tenMauSac") String tenMauSac,
            @Validated @ModelAttribute("mauSacViewModel") MauSacViewModel mauSacViewModel,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/mau-sac/view-add";
        } else {
            MauSac mauSac = new MauSac(ma,tenMauSac);
            mauSacRepository.save(mauSac);
            return "redirect:/mau-sac/hien-thi";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("tenMauSac") String tenMauSac,
                         @Validated @ModelAttribute("mauSacViewModel") MauSacViewModel mauSacViewModel,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/mau-sac/view-update/{id}";
        } else {
            MauSac mauSac = new MauSac(id,ma,tenMauSac);
            mauSacRepository.save(mauSac);
            return "redirect:/mau-sac/hien-thi";
        }
    }

}
