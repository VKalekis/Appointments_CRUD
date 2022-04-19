package com.example.appointments.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public Doctor addDoctor(Doctor doctor) {
       return doctorRepository.save(doctor);
    }

    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id).orElseThrow(
                () -> new DoctorNotFoundException(id)
        );
    }

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }


    public void deleteDoctor(Long id) {
        boolean doctorExists = doctorRepository.existsById(id);
        if (doctorExists) {
            doctorRepository.deleteById(id);
        } else {
            throw new DoctorNotFoundException(id);
        }
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        return doctorRepository.findById(id)
                .map(doctorUpdated -> {

//                    if (!doctor.getFirstName().isEmpty())
//                        doctorUpdated.setFirstName(doctor.getFirstName());
//                    if (!doctor.getLastName().isEmpty())
//                        doctorUpdated.setLastName(doctor.getLastName());
//                    if (!doctor.getSpecialty().isEmpty())
//                        doctorUpdated.setSpecialty(doctor.getSpecialty());

                    doctorUpdated.setFirstName(doctor.getFirstName());
                    doctorUpdated.setLastName(doctor.getLastName());
                    doctorUpdated.setSpecialty(doctor.getSpecialty());
                    doctorUpdated.setDob(doctor.getDob());

                    return doctorRepository.save(doctorUpdated);
                })
                .orElseGet(() -> doctorRepository.save(doctor));
    }

    public List<Doctor> getDoctorsBySpecialty(String spec) {
        return doctorRepository.getDoctorBySpecialty(spec);
    }
}
