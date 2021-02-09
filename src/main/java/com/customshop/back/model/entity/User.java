package com.customshop.back.model.entity;

import com.customshop.back.model.auditable.AuditableSession;
import com.customshop.back.model.dto.SignUpReqDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends AuditableSession {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "user_id", columnDefinition = "uniqueidentifier")
    private UUID userId;

    @Column(name = "cart_id")
    private UUID cartId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
    private List<Role> roles;

    public User(SignUpReqDto signUpReqDto) {
        this.name = signUpReqDto.getName();
        this.password = signUpReqDto.getPassword();
        this.email = signUpReqDto.getEmail();
    }
}
