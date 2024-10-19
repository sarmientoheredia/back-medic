package com.sanjuan.backmedic.medic.infrastructure.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.audit4j.core.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/medics")
@Tag(name = "Medic Controller",description = "Permite realizar las operaciones crud para medic")
public class MedicController {


    private final ModelMapper mapper;


    @Audit(action = "prueba de auditoria user")
    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok("usuario user");
    }



    @Audit(action = "metodo post de admin")
    @PreAuthorize("hasRole('client_admin')")
    @PostMapping("/{name}")
    public ResponseEntity<String> findById(@PathVariable @AuditField(field = "name") String name) {
        return ResponseEntity.ok("usuario admin"+name);
    }
}
