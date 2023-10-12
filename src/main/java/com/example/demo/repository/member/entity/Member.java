package com.example.demo.repository.member.entity;

import com.example.demo.repository.auth.entity.Auth;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String email;
    private String contact;
    private String password;
    private String name;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "member", cascade = CascadeType.REMOVE)
    private Auth auth;

}
