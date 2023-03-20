package com.liulich3ng.controller;

import com.liulich3ng.dto.request.VendorCreateDTO;
import com.liulich3ng.entity.Vendor;
import com.liulich3ng.service.VendorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class VendorController {
    private final VendorService vendorService;

    @GetMapping("/vendors")
    public Page<Vendor> findOnePage() {
        return vendorService.findOnePage(0, 10);
    }

    @PostMapping("/vendors")
    public void createVendor(@RequestBody @Valid VendorCreateDTO vendorCreateDTO) {
        vendorService.create(vendorCreateDTO.getVendorName(), vendorCreateDTO.getLeaderId());
    }
}
