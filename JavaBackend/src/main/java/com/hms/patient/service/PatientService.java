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
    public void addMedication(int patientId,Medication medication){
       patientDAO.addMedication(patientId,medication);
    }

    @Transactional
    public Medication getMedication(int patientId){
        return patientDAO.getMedication(patientId);
    }

    @Transactional
    public void updatePatient(Patient patient){
        patientDAO.updatePatient(patient);
    }

    @Transactional
    public void addPatient(Patient patient){
        patientDAO.addPatient(patient);
    }
}
