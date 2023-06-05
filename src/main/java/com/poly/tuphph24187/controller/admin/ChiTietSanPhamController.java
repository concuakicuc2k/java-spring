package com.poly.tuphph24187.controller.admin;

import com.poly.tuphph24187.bean.ChiTietSanPhamViewModel;
import com.poly.tuphph24187.bean.NhanVienViewModel;
import com.poly.tuphph24187.entity.admin.*;
import com.poly.tuphph24187.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chitiet-sp/")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DongSPRepository dongSPRepository;

    @Autowired
    private NSXRepository nsxRepository;

    @GetMapping("hien-thi")
    public String hienThiCTSP(
            @RequestParam(defaultValue = "0", name = "page") int number, Model model
    ) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<ChiTietSanPham> listCTSP = chiTietSanPhamRepository.findAll(pageable);
        model.addAttribute("listCTSP", listCTSP);
        return "admin/chitiet_sanpham/chitiet-sanpham";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model,
                  @Validated @ModelAttribute("chiTietSanPhamViewModel") ChiTietSanPhamViewModel chiTietSanPhamViewModel,
                  BindingResult result

    ) {
        System.out.println( result.hasErrors() );
        if ( result.hasErrors() == true ) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        List<MauSac> mauSacs = mauSacRepository.findAll();
        model.addAttribute("mauSacs", mauSacs);
        List<SanPham> sanPhams = sanPhamRepository.findAll();
        model.addAttribute("sanPhams", sanPhams);
        List<DongSP> dongSPS = dongSPRepository.findAll();
        model.addAttribute("dongSPS", dongSPS);
        List<NSX> nsxList = nsxRepository.findAll();
        model.addAttribute("nsxList", nsxList);
        return "admin/chitiet_sanpham/add-chitiet-sanpham";
    }

    @PostMapping("add")
    public String addNhanVien(Model model,
                              @RequestParam("mauSac") MauSac mauSacid, @RequestParam("sanPham") SanPham sanPhamid,
                              @RequestParam("dongSP") DongSP dongSPid, @RequestParam("nsx") NSX nsxid,
                              @RequestParam("namBH") String namBH, @RequestParam("moTa") String moTa,
                              @RequestParam("soLuongTon") String soLuongTon, @RequestParam("giaNhap") String giaNhap,
                              @RequestParam("giaBan") String giaBan,
                              @Validated @ModelAttribute("chiTietSanPhamViewModel") ChiTietSanPhamViewModel chiTietSanPhamViewModel,
                              BindingResult result
    ) {
        if (result.hasErrors()) {
            List<MauSac> mauSacs = mauSacRepository.findAll();
            model.addAttribute("mauSacs", mauSacs);
            List<SanPham> sanPhams = sanPhamRepository.findAll();
            model.addAttribute("sanPhams", sanPhams);
            List<DongSP> dongSPS = dongSPRepository.findAll();
            model.addAttribute("dongSPS", dongSPS);
            List<NSX> nsxList = nsxRepository.findAll();
            model.addAttribute("nsxList", nsxList);
            return "admin/chitiet_sanpham/add-chitiet-sanpham";
        } else {
            MauSac mauSac = mauSacRepository.findById(mauSacid.getId()).orElse(null);
            SanPham sanPham = sanPhamRepository.findById(sanPhamid.getId()).orElse(null);
            DongSP dongSP = dongSPRepository.findById(dongSPid.getId()).orElse(null);
            NSX nsx = nsxRepository.findById(nsxid.getId()).orElse(null);

            ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
                    .mauSac(mauSac)
                    .sanPham(sanPham)
                    .dongSP(dongSP)
                    .nsx(nsx)
                    .namBH(Integer.valueOf(namBH))
                    .moTa(moTa)
                    .soLuongTon(Integer.valueOf(soLuongTon))
                    .giaNhap(BigDecimal.valueOf(Long.parseLong(giaNhap)))
                    .giaBan(BigDecimal.valueOf(Long.parseLong(giaBan)))
                    .build();
            this.chiTietSanPhamRepository.save(chiTietSanPham);
        }
        return "redirect:/chitiet-sp/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model,
                             @Validated @ModelAttribute("chiTietSanPhamViewModel") ChiTietSanPhamViewModel chiTietSanPhamViewModel,
                             BindingResult result
    ) {
        System.out.println( result.hasErrors() );
        if ( result.hasErrors() == true ) {
            System.out.println("Form ko hợp lệ");
        } else {
            System.out.println("Form hợp lệ");
        }
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElse(null);
        model.addAttribute("chiTietSanPham", chiTietSanPham);

        List<MauSac> mauSacs = mauSacRepository.findAll();
        model.addAttribute("mauSacs", mauSacs);
        List<SanPham> sanPhams = sanPhamRepository.findAll();
        model.addAttribute("sanPhams", sanPhams);
        List<DongSP> dongSPs = dongSPRepository.findAll();
        model.addAttribute("dongSPs", dongSPs);
        List<NSX> nsxList = nsxRepository.findAll();
        model.addAttribute("nsxList", nsxList);
        return "admin/chitiet_sanpham/update-chitiet-sanpham";
    }

    @PostMapping("update/{id}")
    public String updateNhanVien(Model model,
                                 @PathVariable("id") UUID id, @RequestParam("mauSac") MauSac mauSacid, @RequestParam("sanPham") SanPham sanPhamid,
                                 @RequestParam("dongSP") DongSP dongSPid, @RequestParam("nsx") NSX nsxid,
                                 @RequestParam("namBH") String namBH, @RequestParam("moTa") String moTa,
                                 @RequestParam("soLuongTon") String soLuongTon, @RequestParam("giaNhap") String giaNhap,
                                 @RequestParam("giaBan") String giaBan,
                                 @Validated @ModelAttribute("chiTietSanPhamViewModel") ChiTietSanPhamViewModel chiTietSanPhamViewModel,
                                 BindingResult result
    ) {
        if (result.hasErrors()) {
            ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElse(null);
            List<MauSac> mauSacs = mauSacRepository.findAll();
            model.addAttribute("mauSacs", mauSacs);
            List<SanPham> sanPhams = sanPhamRepository.findAll();
            model.addAttribute("sanPhams", sanPhams);
            List<DongSP> dongSPs = dongSPRepository.findAll();
            model.addAttribute("dongSPs", dongSPs);
            List<NSX> nsxList = nsxRepository.findAll();
            model.addAttribute("nsxList", nsxList);
            return "redirect:/chitiet-sp/view-update/{id}";
        } else {
            MauSac mauSac = mauSacRepository.findById(mauSacid.getId()).orElse(null);
            SanPham sanPham = sanPhamRepository.findById(sanPhamid.getId()).orElse(null);
            DongSP dongSP = dongSPRepository.findById(dongSPid.getId()).orElse(null);
            NSX nsx = nsxRepository.findById(nsxid.getId()).orElse(null);

            ChiTietSanPham chiTietSanPham = new ChiTietSanPham(id,sanPham,nsx,mauSac,dongSP,
                    Integer.valueOf(namBH),moTa,Integer.valueOf(soLuongTon),BigDecimal.valueOf(Long.parseLong(giaNhap)),BigDecimal.valueOf(Long.parseLong(giaBan)));
            this.chiTietSanPhamRepository.save(chiTietSanPham);
        }
        return "redirect:/chitiet-sp/hien-thi";
    }



    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        this.chiTietSanPhamRepository.deleteById(id);
        return "redirect:/chitiet-sp/hien-thi";
    }
}
