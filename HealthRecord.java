package petmanagement;

public class HealthRecord {
    private String vaccinationDate;
    private String medicalHistory;
    private String allergies;

    public HealthRecord(String vaccinationDate, String medicalHistory, String allergies) {
        this.vaccinationDate = vaccinationDate;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
    }

    public void addRecord(String vaccinationDate, String medicalHistory, String allergies) {
        this.vaccinationDate = vaccinationDate;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
    }

    public void getRecord() {
        System.out.println("Vaccination Date: " + vaccinationDate);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Allergies: " + allergies);
    }
}


