package com.liulich3ng.service;

import com.liulich3ng.constant.ROLE;
import com.liulich3ng.entity.User;
import com.liulich3ng.entity.Vendor;
import com.liulich3ng.repository.UserRepository;
import com.liulich3ng.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;
    private final UserRepository userRepository;

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Page<Vendor> findOnePage(int pageNum, int pageSize) {
        return vendorRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    public void create(String name, Integer leaderId) {
        Vendor vendor = Vendor.builder()
                .name(name)
                .build();
        Vendor savedVendor = vendorRepository.save(vendor);
        User leader = userRepository.findById(leaderId).orElseThrow();
        leader.setVendor(savedVendor);
        leader.setRole(ROLE.LEADER);
        userRepository.save(leader);
    }
}
