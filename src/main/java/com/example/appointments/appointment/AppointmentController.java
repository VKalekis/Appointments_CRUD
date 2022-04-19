package com.example.appointments.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;


    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @PostMapping()
    public Appointment addAppointment(@RequestBody AppointmentRequestBody appointmentsRequestBody) {
        System.out.println(appointmentsRequestBody);

        return appointmentService.addAppointment(appointmentsRequestBody);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
    }
}
