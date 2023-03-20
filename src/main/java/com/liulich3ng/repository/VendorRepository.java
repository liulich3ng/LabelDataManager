package com.liulich3ng.repository;

import com.liulich3ng.entity.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor,Integer> {
    @Override
    List<Vendor> findAll();

    @Override
    Optional<Vendor> findById(Integer integer);

    Optional<Vendor> findByName(String name);

    @Override
    Page<Vendor> findAll(Pageable pageable);
}
