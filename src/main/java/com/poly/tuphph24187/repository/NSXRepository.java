package com.poly.tuphph24187.repository;

import com.poly.tuphph24187.entity.admin.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NSXRepository extends JpaRepository<NSX, UUID> {



}
