package com.example.appointments.appointment;

import java.time.LocalDateTime;

public class AppointmentRequestBody {

    private Long doctorId;
    private Long patientId;
    private String description;
    private LocalDateTime localDateTime;

    public AppointmentRequestBody(Long doctorId, Long patientId, String description, LocalDateTime localDateTime) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.description = description;
        this.localDateTime = localDateTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "AppointmentRequestBody{" +
                "doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", description='" + description + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
