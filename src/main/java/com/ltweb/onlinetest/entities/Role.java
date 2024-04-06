package com.ltweb.onlinetest.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long roleId;
    
    @Column
    @Enumerated(EnumType.STRING)
    private ERole rolename;
}