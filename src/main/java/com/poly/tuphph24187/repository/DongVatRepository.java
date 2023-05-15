package com.poly.tuphph24187.repository;

import com.poly.tuphph24187.entity.DongVat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongVatRepository extends JpaRepository<DongVat, Long> {
}
