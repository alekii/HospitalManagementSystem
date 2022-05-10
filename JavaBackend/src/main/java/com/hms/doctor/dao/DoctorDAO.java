package com.hms.doctor.dao;

import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;

import java.util.List;

public interface DoctorDAO {
     List<Doctor> findAll();
     Doctor findById(int Id);
     void save(Doctor doctor);
     void delete(int Id);

    void addMedication(Medication medication);
}
