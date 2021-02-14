package com.customshop.back.auth.security.jwt;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

@Data
public class JwtUser implements UserDetails {

    private final UUID userId;
    private final String username;
    private final String password;
    private final String email;
    private final Boolean enabled;
    private final Timestamp lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(UUID userId, String username, String password, String email, Boolean enabled,
            Timestamp lastPasswordResetDate, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
    }

    @Override
//    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
