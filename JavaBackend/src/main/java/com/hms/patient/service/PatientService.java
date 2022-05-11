package com.hms.patient.service;

import com.hms.patient.dao.PatientDAO;
import com.hms.patient.entity.Medication;
import com.hms.patient.entity.Patient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    private final PatientDAO patientDAO;

    public PatientService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Transactional
    public Patient findPatient(int patientId){
        return patientDAO.findPatient(patientId);
    }

    @Transactional
    public void addMedication(Medication medication){
       patientDAO.addMedication(medication);
    }

    @Transactional
    public void save(Patient patient){
        patientDAO.updatePatient(patient);
    }
}
