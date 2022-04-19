package com.example.appointments.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException(id)
        );
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        boolean patientExists = patientRepository.existsById(id);
        if (patientExists) {
            patientRepository.deleteById(id);
        } else {
            throw new PatientNotFoundException(id);
        }
    }
}
