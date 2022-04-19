package com.example.appointments.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> getDoctorBySpecialty(String specialty);
}
