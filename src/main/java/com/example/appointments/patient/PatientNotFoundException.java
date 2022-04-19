package com.example.appointments.patient;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(Long id) {
        super("No patient found with id " + id);
    }
}
