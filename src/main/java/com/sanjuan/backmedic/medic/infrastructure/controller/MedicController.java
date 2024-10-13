package com.sanjuan.backmedic.medic.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/medics")
public class MedicController {


    private final ModelMapper mapper;



    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<String> findAll() {

        return ResponseEntity.ok("usuario user");
    }

    @PreAuthorize("hasRole('client_admin')")
    @GetMapping("/admin")
    public ResponseEntity<String> findById() {

        return ResponseEntity.ok("usuario admin");
    }
}
