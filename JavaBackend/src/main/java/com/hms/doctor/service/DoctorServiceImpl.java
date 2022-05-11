package com.hms.doctor.service;

import com.hms.doctor.dao.DoctorDAO;
import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
   private final DoctorDAO doctorDAO;

    public DoctorServiceImpl(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Override
    @Transactional
    public List<Doctor> findAll() {
        return doctorDAO.findAll();
    }

    @Override
    @Transactional
    public Doctor findById(int Id) {
        return doctorDAO.findById(Id);
    }

    @Override
    @Transactional
    public void save(Doctor doctor) {
        doctorDAO.save(doctor);
    }

    @Override
    @Transactional
    public void delete(int Id) {
        doctorDAO.delete(Id);
    }

}
