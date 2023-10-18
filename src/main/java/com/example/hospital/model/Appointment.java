package com.example.hospital.model;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Appointment {

    private Long id;
    private LocalDateTime appointmentDate;
    private String patientName;
    private String doctorName;
    private String reason;

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime appointmentDate, String patientName, String doctorName, String reason) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.reason = reason;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate){
        this.appointmentDate = appointmentDate;
    }

    public void setPatientName(String patientName){
        this.patientName = patientName;
    }

    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }

    public void setReason(String reason){
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentDate=" + appointmentDate +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
