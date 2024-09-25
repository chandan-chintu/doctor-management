package com.example.doctor_management.controller;

import com.example.doctor_management.model.Doctor;
import com.example.doctor_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController//@Controller + @ResponseBody
@RequestMapping("/doctor/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctorRequest){
        // passes the request into service class
        String response = doctorService.addDoctor(doctorRequest);
        return response;
    }

    @GetMapping("/find/{doctorid}")
    public Doctor findDoctorById(@PathVariable("doctorid") int doctorId){
        Doctor doctor = doctorService.findDoctorById(doctorId);
        return doctor;
    }

    @GetMapping("/findall")
    public List<Doctor> findAllDoctor(){
        List<Doctor> doctorList = doctorService.findAllDoctor();
        return doctorList;
    }
}
