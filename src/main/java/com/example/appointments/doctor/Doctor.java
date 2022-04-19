package com.example.appointments.doctor;

import com.example.appointments.appointment.Appointment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )


    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private LocalDate dob;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Appointment> appointmentList = new ArrayList<>();

    public void setAppointment(Appointment appointment) {
        this.appointmentList.add(appointment);
        appointment.setDoctor(this);
    }



    public Doctor(String firstName, String lastName, String specialty, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.dob = dob;
    }

    public Doctor() {
    }

    public Doctor(Long id, String firstName, String lastName, String specialty, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.dob = dob;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", dob=" + dob +
                '}';
    }
}
