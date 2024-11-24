package petmanagement;

public class HealthRecord {
    private String vaccinationDate;
    private String medicalHistory;

    public HealthRecord(String vaccinationDate, String medicalHistory) {
        this.vaccinationDate = vaccinationDate;
        this.medicalHistory = medicalHistory;
    }

    public void addRecord(String vaccinationDate, String medicalHistory) {
        this.vaccinationDate = vaccinationDate;
        this.medicalHistory = medicalHistory;
    }

    public void getRecord() {
        System.out.println("Vaccination Date: " + vaccinationDate);
        System.out.println("Medical History: " + medicalHistory);
    }
}

