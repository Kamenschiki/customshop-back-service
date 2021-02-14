package com.customshop.back.model.entity.auth;

import com.customshop.back.model.dto.auth.SignUpReqDto;
import com.customshop.back.model.entity.BasicDetails;
import com.customshop.back.model.entity.Detailed;
import com.customshop.back.model.entity.auditable.AuditableSession;
import com.customshop.back.model.entity.auth.details.UserDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "USERS")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Component
public class User extends AuditableSession implements Detailed<UserDetails> {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "USER_ID", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") })
    private List<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserDetails> userDetails;

    public User(SignUpReqDto signUpReqDto) {
        this.name = signUpReqDto.getName();
        this.password = signUpReqDto.getPassword();
        this.email = signUpReqDto.getEmail();
    }

    @Override
    public List<UserDetails> getDetails() {
        return userDetails;
    }

    @Override
    public void setDetails(List<BasicDetails> basicDetails) {
        this.userDetails = basicDetails.stream().map(details -> (UserDetails) details).collect(Collectors.toList());
    }

    @Override
    public UUID getPk() {
        return this.userId;
    }
}
