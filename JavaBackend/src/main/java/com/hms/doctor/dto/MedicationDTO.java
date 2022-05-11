package com.hms.doctor.dto;

import com.hms.patient.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MedicationDTO {
    private int patientId;
    private String diagnosis;
    private String drugs;
    private String treatment;
    private final Timestamp dateDiagnosed = Timestamp.from(Instant.now());
    private double treatmentAmount;
}
