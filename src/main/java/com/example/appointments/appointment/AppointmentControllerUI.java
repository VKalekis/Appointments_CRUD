package com.example.appointments.appointment;

import com.example.appointments.appointment.Appointment;
import com.example.appointments.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/appointments")
public class AppointmentControllerUI {
    private AppointmentService appointmentService;

    @Autowired
    public AppointmentControllerUI(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/ui")
    public String bootstrap(Model model) {
        List<Appointment> appointmentList = appointmentService.getAppointments();
        model.addAttribute("appointmentList", appointmentList);
        return "appointments";
    }
}
