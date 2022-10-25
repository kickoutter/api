package com.rest.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="user1")

@Builder // builder를 사용할 수 있게 한다.
@Getter
@Setter
@NoArgsConstructor // 인자없는 생성자 자동 생성
@AllArgsConstructor // 인자 모두 있는 생성자 자동 생성
public class User implements UserDetails {

    /*
    !!!JPA 기본키 전략에 대해서는 좀 더 공부해보자!!!
     */
    @Id //primaryKey라는 뜻
    @GeneratedValue(strategy= GenerationType.IDENTITY) //pk생성전략을 DB에 위임. 예를들어 auto_increment
    private long msrl;
    @Column(nullable=false, unique=true, length=30)
    private String uid;
    @Column(nullable=false, length=100)
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 100)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Json결과로 출력 안한다.
    @Override
    public String getUsername() {
        return this.uid;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
