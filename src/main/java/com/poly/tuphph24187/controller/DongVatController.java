package com.poly.tuphph24187.controller;

import com.poly.tuphph24187.entity.DongVat;
import com.poly.tuphph24187.repository.DongVatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hangnt169
 */
@Controller
@RequestMapping("/dong-vat/")
public class DongVatController {
    @Autowired
    private DongVatRepository dongVatRepository;

    @GetMapping("hien-thi")
    public String hienThiDongVat(Model model) {
        List<DongVat> dongvats = dongVatRepository.findAll();
        model.addAttribute("dongvats", dongvats);
        return "dong-vat/dong-vat";
    }

    @GetMapping("view-add")
    public String viewAddLopHoc() {
        return "dong-vat/add-dong-vat";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateLopHoc(@PathVariable("id") Long id, Model model) {
        DongVat lop = dongVatRepository.findById(id).get();
        model.addAttribute("dongVat", lop);
        return "dong-vat/update-dong-vat";
    }

    @GetMapping("detail/{id}")
    public String detailLopHoc(@PathVariable("id") Long id, Model model) {
        DongVat lop = dongVatRepository.findById(id).get();
        model.addAttribute("dongVat", lop);
        return "dong-vat/detail-dong-vat";
    }

    @GetMapping("delete/{id}")
    public String deleteLopHoc(@PathVariable("id") Long id, Model model) {
        DongVat lop = dongVatRepository.findById(id).get();
        dongVatRepository.delete(lop);
        List<DongVat> dongvats = dongVatRepository.findAll();
        model.addAttribute("dongvats", dongvats);
        return "dong-vat/dong-vat";
    }

    @PostMapping("add")
    public String add(@RequestParam("ten") String ten, @RequestParam("canNang") String canNang,
                      @RequestParam("gioiTinh") String gioiTinh, @RequestParam("namSinh") String namSinh) {
        DongVat dongVat = new DongVat(ten, Float.valueOf(canNang), Boolean.valueOf(gioiTinh), Integer.valueOf(namSinh));
        dongVatRepository.save(dongVat);
        return "redirect:/dong-vat/hien-thi";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Long id, @RequestParam("ten") String ten, @RequestParam("canNang") String canNang,
                         @RequestParam("gioiTinh") String gioiTinh, @RequestParam("namSinh") String namSinh) {
        DongVat dongVat = new DongVat(id, ten, Float.valueOf(canNang), Boolean.valueOf(gioiTinh), Integer.valueOf(namSinh));
        dongVatRepository.save(dongVat);
        return "redirect:/dong-vat/hien-thi";
    }
}
