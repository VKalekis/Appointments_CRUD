package com.example.appointments.doctor;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    //Returns all doctors.
    @GetMapping
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    // Returns the doctor with the specific id.
    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.getDoctor(id);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        // Maps json to doctor object -> adds it to the DB.
        //System.out.println(doctor);
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        //System.out.println("DEL_ID"+id);
        doctorService.deleteDoctor(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id,
                             @RequestBody Doctor doctor) {
       return doctorService.updateDoctor(id, doctor);
    }

    @GetMapping ("/specialty/{spec}")
    public List<Doctor> getDoctorsBySpecialtyPV(@PathVariable String spec) {
        return doctorService.getDoctorsBySpecialty(spec);
    }
    @GetMapping ("/specialty")
    public List<Doctor> getDoctorsBySpecialty(@RequestParam(required = true) String spec) {
        return doctorService.getDoctorsBySpecialty(spec);
    }

//    @PutMapping("/put/{id}")
//    public void updateDoctor(@PathVariable Long id,
//                             @RequestParam(required = false) String first_name,
//                             @RequestParam(required = false) String last_name) {
//
//        doctorService.updateDoctor(id, first_name, last_name);
//    }








}
