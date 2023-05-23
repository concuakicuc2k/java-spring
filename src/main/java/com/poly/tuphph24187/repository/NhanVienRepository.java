package com.poly.tuphph24187.repository;

import com.poly.tuphph24187.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface NhanVienRepository  extends JpaRepository<NhanVien, UUID> {
}
