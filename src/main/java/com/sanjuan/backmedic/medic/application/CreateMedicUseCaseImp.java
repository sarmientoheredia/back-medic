package com.sanjuan.backmedic.medic.application;

import com.sanjuan.backmedic.medic.domain.model.Medic;
import com.sanjuan.backmedic.medic.domain.puerto.MedicRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateMedicUseCaseImp implements CreateMedicUseCase{


    private final MedicRepository medicRepository;
    @Override
    public Medic createMedic(Medic medic) {
        return medicRepository.createMedic(medic);
    }
}
