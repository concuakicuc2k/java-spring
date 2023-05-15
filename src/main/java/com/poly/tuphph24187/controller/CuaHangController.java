package com.poly.tuphph24187.controller;

import com.poly.tuphph24187.entity.CuaHang;
import com.poly.tuphph24187.repository.CuaHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "cua-hang";
    }

    @GetMapping("view-add")
    public String viewAddCuaHang() {
        return "add-cua-hang";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateCuaHang(@PathVariable("id") UUID id, Model model) {
        CuaHang cuaHang = cuaHangRepository.findById(id).get();
        model.addAttribute("cuaHang", cuaHang);
        return "update-cua-hang";
    }

    @GetMapping("detail/{id}")
    public String detailLopHoc(@PathVariable("id") UUID id, Model model) {
        CuaHang cuaHang = cuaHangRepository.findById(id).get();
        model.addAttribute("cuaHang", cuaHang);
        return "detail-cua-hang";
    }

    @GetMapping("delete/{id}")
    public String deleteLopHoc(@PathVariable("id") UUID id, Model model) {
        CuaHang cuaHang = cuaHangRepository.findById(id).get();
        cuaHangRepository.delete(cuaHang);
        List<CuaHang> cuaHangs = cuaHangRepository.findAll();
        model.addAttribute("cuaHangs", cuaHangs);
        return "dong-vat";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("thanhPho") String thanhPho,
                      @RequestParam("quocGia") String quocGia
    ) {
        CuaHang cuaHang = new CuaHang(ma,ten,diaChi,thanhPho,quocGia);
        cuaHangRepository.save(cuaHang);
        return "redirect:/cua-hang/hien-thi";

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id,
                         @RequestParam("ma") String ma,
                         @RequestParam("ten") String ten,
                         @RequestParam("diaChi") String diaChi,
                         @RequestParam("thanhPho") String thanhPho,
                         @RequestParam("quocGia") String quocGia
    ) {
        CuaHang cuaHang = new CuaHang(id,ma,ten,diaChi,thanhPho,quocGia);
        cuaHangRepository.save(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
}
