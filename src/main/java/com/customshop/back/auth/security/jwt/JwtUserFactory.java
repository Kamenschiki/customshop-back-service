package com.customshop.back.auth.security.jwt;

import com.customshop.back.model.entity.Role;
import com.customshop.back.model.entity.User;
import com.customshop.back.model.entity.auditable.AuditableStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(user.getUserId(), user.getName(), user.getPassword(), user.getEmail(),
                user.getAuditableStatus().equals(AuditableStatus.ACTIVE), user.getUpdateDateTimeUtc(),
                mapToGranterAuthorities(user.getRoles()));
    }

    private static List<GrantedAuthority> mapToGranterAuthorities(List<Role> userRoles) {
        return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
