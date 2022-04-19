package com.example.appointments.appointment;

import com.example.appointments.doctor.Doctor;
import com.example.appointments.patient.Patient;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private Long id;

    private String description;
    private LocalDateTime localDateTime;

    @ManyToOne()
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne()
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Appointment(String description, LocalDateTime localDateTime) {
        this.description = description;
        this.localDateTime = localDateTime;
    }

    public Appointment() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", localDateTime=" + localDateTime +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
