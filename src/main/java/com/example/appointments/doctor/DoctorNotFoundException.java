package com.example.appointments.doctor;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(Long id) {
        super("No doctor found with id " + id);
    }
}
