package com.example.demoJPACA2213;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false , length = 50)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String tel;
}
