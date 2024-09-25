package com.example.doctor_management.service;

import com.example.doctor_management.model.Doctor;
import com.example.doctor_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service // it contains business and application logic
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctorRequest){
        // first create Doctor object
        Doctor doctor = new Doctor();
        // take doctorRequest and add it inside dcotor object
        doctor.setDoctorName(doctorRequest.getDoctorName());
        doctor.setDesignation(doctorRequest.getDesignation());
        doctor.setMobile(doctorRequest.getMobile());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setQualification(doctorRequest.getQualification());
        // now save the doctor
        doctor = doctorRepository.save(doctor);
        return "Doctor Saved successfully";
    }

    public Doctor findDoctorById(int doctorId){
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        Doctor doctor = doctorOptional.get();
        return doctor;
    }

    public List<Doctor> findAllDoctor(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }
}
