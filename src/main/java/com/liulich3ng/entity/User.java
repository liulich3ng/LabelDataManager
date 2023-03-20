package com.liulich3ng.entity;

import com.liulich3ng.constant.GENDER;
import com.liulich3ng.constant.ROLE;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    @Email()
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birth;

    private GENDER gender;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ROLE role = ROLE.WORKER;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Vendor.class)
    @JoinColumn(name = "vendor", referencedColumnName = "id")
    private Vendor vendor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Builder.Default
    private boolean locked = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}