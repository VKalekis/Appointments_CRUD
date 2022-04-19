package com.example.appointments.appointment;

import com.example.appointments.doctor.Doctor;
import com.example.appointments.doctor.DoctorNotFoundException;
import com.example.appointments.doctor.DoctorService;
import com.example.appointments.patient.Patient;
import com.example.appointments.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    private DoctorService doctorService;
    private PatientService patientService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorService doctorService, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id).orElseThrow(
                () -> new AppointmentNotFoundException(id)
        );
    }

    public Appointment addAppointment(AppointmentRequestBody appointmentRequestBody) {

        // Create a new Appointment object.
        Appointment appointment = new Appointment(appointmentRequestBody.getDescription(), appointmentRequestBody.getLocalDateTime());
        // Get the doctor with the specific id from the db.
        Doctor doctor = doctorService.getDoctor(appointmentRequestBody.getDoctorId());
        // Get the doctor with the specific id from the db.
        Patient patient = patientService.getPatient(appointmentRequestBody.getPatientId());

        doctor.setAppointment(appointment);
        patient.setAppointment(appointment);

        System.out.println(doctor);
        System.out.println(patient);
        System.out.println(appointment);

        return appointmentRepository.save(appointment);
    }


    public void deleteAppointment(long id) {

        boolean appointmentExists = appointmentRepository.existsById(id);
        if (appointmentExists) {
            appointmentRepository.deleteById(id);
        } else {
            throw new AppointmentNotFoundException(id);
        }
    }
}
