package com.sanjuan.backmedic.medic.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MEDIC")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedic;

    @Column( length = 20)
    private String cedula;

    @Column(nullable = false, length = 70)
    private String firstName;

    @Column(nullable = false, length = 70)
    private String lastName;

    @Column(nullable = false, length = 15,unique = true)
    private String cmp;

    private String photoUrl;
}
