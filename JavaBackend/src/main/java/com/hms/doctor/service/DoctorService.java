package com.hms.doctor.service;

import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;
import com.hms.patient.entity.Patient;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAll();
    Doctor findById(int Id);
    void save(Doctor doctor);
    void delete(int Id);
}
