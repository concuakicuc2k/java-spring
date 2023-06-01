package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.entity.ChucVu;
import com.poly.tuphph24187.entity.CuaHang;
import com.poly.tuphph24187.entity.NhanVien;
import com.poly.tuphph24187.repository.ChucVuRepository;
import com.poly.tuphph24187.repository.CuaHangRepository;
import com.poly.tuphph24187.repository.NhanVienRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping("hien-thi")
    public String hienThiNhanVien(
            @RequestParam(defaultValue = "0", name = "page") int number, Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<NhanVien> nhanViens = nhanVienRepository.findAll(pageable);
        model.addAttribute("nhanViens", nhanViens);
        return "admin/nhan_vien/nhan-vien";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        List<CuaHang> cuaHangs = cuaHangRepository.findAll();
        model.addAttribute("cuaHangs", cuaHangs);
        List<ChucVu> chucVus = chucVuRepository.findAll();
        model.addAttribute("chucVus", chucVus);
        return "admin/nhan_vien/add-nhan-vien";
    }

    @PostMapping("add")
    public String addNhanVien(
                @RequestParam("ma") String ma,
                @RequestParam("ho") String ho,
                @RequestParam("tenDem") String tenDem,
                @RequestParam("ten") String ten,
                @RequestParam("ngaySinh") String ngaySinh,
                @RequestParam("sdt") String sdt,
                @RequestParam("diaChi") String diaChi,
                @RequestParam("password") String password,
                @RequestParam("gioiTinh") int gioiTinh,
                @RequestParam("cuaHang") CuaHang cuaHangid,
                @RequestParam("chucVu") ChucVu chucVuid
    ) {
        CuaHang cuaHang = cuaHangRepository.findById(cuaHangid.getId()).orElse(null);
        ChucVu chucVu = chucVuRepository.findById(chucVuid.getId()).orElse(null);
        NhanVien nhanVien = NhanVien.builder()
                .ma(ma)
                .ho(ho)
                .tenDem(tenDem)
                .ten(ten)
                .gioiTinh(Integer.valueOf(gioiTinh))
                .ngaySinh(ngaySinh)
                .diaChi((diaChi))
                .sdt(sdt)
                .password(password)
                .chucVu(chucVu)
                .cuaHang(cuaHang)
                .build();
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElse(null);
        List<ChucVu> chucVus = chucVuRepository.findAll();
        model.addAttribute("chucVus", chucVus);
        List<CuaHang> cuaHangs = cuaHangRepository.findAll();
        model.addAttribute("cuaHangs", cuaHangs);
        model.addAttribute("nhanVien", nhanVien);
        return "admin/nhan_vien/update-nhan-vien";
    }

    @PostMapping("update/{id}")
    public String updateNhanVien(
            @PathVariable("id") UUID id,
            @RequestParam("ma") String ma,
            @RequestParam("ho") String ho,
            @RequestParam("tenDem") String tenDem,
            @RequestParam("ten") String ten,
            @RequestParam("ngaySinh") String ngaySinh,
            @RequestParam("sdt") String sdt,
            @RequestParam("diaChi") String diaChi,
            @RequestParam("password") String password,
            @RequestParam("gioiTinh") int gioiTinh,
            @RequestParam("trangThai") int trangThai,
            @RequestParam("cuaHang") CuaHang cuaHangid,
            @RequestParam("chucVu") ChucVu chucVuid
    ) {
        CuaHang cuaHang = cuaHangRepository.findById(cuaHangid.getId()).orElse(null);
        ChucVu chucVu = chucVuRepository.findById(chucVuid.getId()).orElse(null);
        NhanVien nhanVien = new NhanVien(id,ma,ho,tenDem,ten,gioiTinh,ngaySinh,diaChi,sdt,password,trangThai,chucVu,cuaHang);
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElse(null);
        Pageable pageable = PageRequest.of(0, 5);
        Page<NhanVien> listNhanVien = nhanVienRepository.findAll(pageable);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("listNhanVien", listNhanVien);
        return "admin/nhan_vien/detail-nhan-vien";
    }

}
