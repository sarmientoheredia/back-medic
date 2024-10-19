package com.sanjuan.backmedic.medic.domain.puerto;

import com.sanjuan.backmedic.medic.domain.model.Medic;

import java.util.List;
import java.util.Optional;

public interface MedicRepository {
    List<Medic> findAll();
    Optional<Medic> findById(Long idMedic);
    Medic createMedic(Medic medic);
    Medic updateMedic(Medic medic);
    void deleteMedicById(Long idMedic);

}
