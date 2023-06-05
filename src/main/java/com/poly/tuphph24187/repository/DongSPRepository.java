package com.poly.tuphph24187.repository;

import com.poly.tuphph24187.entity.admin.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSPRepository extends JpaRepository<DongSP, UUID> {



}
