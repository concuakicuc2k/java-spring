package com.poly.tuphph24187.controller.admin;


import com.poly.tuphph24187.bean.NSXViewModel;
import com.poly.tuphph24187.entity.admin.NSX;
import com.poly.tuphph24187.repository.NSXRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/n-s-x/")
public class NSXController {

    @Autowired
    private NSXRepository nsxRepository;

    @GetMapping("hien-thi")
    public String hienThiNSX(Model model) {
        List<NSX> nsxList = nsxRepository.findAll();
        model.addAttribute("nsxList", nsxList);
        return "admin/n_s_x/n-s-x";
    }

    @GetMapping("view-add")
    public String viewAddNSX(
            Model model,
            @Validated @ModelAttribute("nsxViewModel") NSXViewModel nsxViewModel,
            BindingResult result
    ) {
        System.out.println( result.hasErrors() );
        if (result.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        return "admin/n_s_x/add-n-s-x";
    }


    @GetMapping("view-update/{id}")
    public String viewUpdateNSX(
            @PathVariable("id") UUID id, Model model,
            @Validated @ModelAttribute("nsxViewModel") NSXViewModel nsxViewModel,
            BindingResult result
    ) {
        if (result.hasErrors() == true) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        NSX nsx = nsxRepository.findById(id).get();
        model.addAttribute("nsx", nsx);
        return "admin/n_s_x/update-n-s-x";
    }

    @GetMapping("delete/{id}")
    public String deleteNSX(@PathVariable("id") UUID id, Model model) {
        NSX nsx = nsxRepository.findById(id).get();
        nsxRepository.delete(nsx);
        List<NSX> nsxList = nsxRepository.findAll();
        model.addAttribute("nsxList", nsxList);
        return "admin/n_s_x/n-s-x";
    }

    @PostMapping("add")
    public String add(
            @RequestParam("ma") String ma,
            @RequestParam("tenNSX") String tenNSX,
            @Validated @ModelAttribute("nsxViewModel") NSXViewModel nsxViewModel,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/san-pham/view-add";
        } else {
            NSX nsx = new NSX(ma,tenNSX);
            nsxRepository.save(nsx);
            return "redirect:/n-s-x/hien-thi";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("tenNSX") String tenNSX,
                         @Validated @ModelAttribute("nsxViewModel") NSXViewModel nsxViewModel,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            return "redirect:/n-s-x/view-update/{id}";
        } else {
            NSX nsx = new NSX(id,ma,tenNSX);
            nsxRepository.save(nsx);
            return "redirect:/n-s-x/hien-thi";
        }
    }

}
