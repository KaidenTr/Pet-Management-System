package petmanagement;

public class Appointment {
    private String appointmentDate;
    private String vetName;

    public Appointment(String appointmentDate, String vetName) {
        this.appointmentDate = appointmentDate;
        this.vetName = vetName;
    }

    public void scheduleAppointment(String appointmentDate, String vetName) {
        this.appointmentDate = appointmentDate;
        this.vetName = vetName;
    }

    public void getAppointmentDetails() {
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Vet Name: " + vetName);
    }
}

