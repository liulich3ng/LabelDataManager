package com.liulich3ng.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotNull
    @Length(min = 6, max = 20)
    private String username;

    @NotNull
    @Length(min = 8, max = 20)
    private String password;
}
