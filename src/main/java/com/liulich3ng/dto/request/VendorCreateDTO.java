package com.liulich3ng.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorCreateDTO {
    @NotNull
    @NotBlank
    private String vendorName;

    @NotNull
    private Integer leaderId;
}
