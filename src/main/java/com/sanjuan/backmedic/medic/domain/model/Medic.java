package com.sanjuan.backmedic.medic.domain.model;

import lombok.Data;

@Data
public class Medic {

    private Long idMedic;

    private String cedula;

    private String firstName;

    private String lastName;

    private String cmp;

    private String photoUrl;
}
