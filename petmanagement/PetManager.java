package petmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetManager {
    private List<Pet> pets = new ArrayList<>();
    private Map<String, HealthRecord> healthRecords = new HashMap<>();
    private Map<String, FeedingSchedule> feedingSchedules = new HashMap<>();
    private Map<String, Appointment> appointments = new HashMap<>();

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addHealthRecord(String petName, HealthRecord healthRecord) {
        healthRecords.put(petName, healthRecord);
    }

    public void addFeedingSchedule(String petName, FeedingSchedule feedingSchedule) {
        feedingSchedules.put(petName, feedingSchedule);
    }

    public void addAppointment(String petName, Appointment appointment) {
        appointments.put(petName, appointment);
    }

    public void getPetDetails(String petName) {
        for (Pet pet : pets) {
            if (pet.getName().equals(petName)) {
                pet.getDetails();
                break;
            }
        }
    }

    public void getHealthRecord(String petName) {
        if (healthRecords.containsKey(petName)) {
            healthRecords.get(petName).getRecord();
        } else {
            System.out.println("No health record found for " + petName);
        }
    }

    public void getFeedingSchedule(String petName) {
        if (feedingSchedules.containsKey(petName)) {
            feedingSchedules.get(petName).getSchedule();
        } else {
            System.out.println("No feeding schedule found for " + petName);
        }
    }

    public void getAppointmentDetails(String petName) {
        if (appointments.containsKey(petName)) {
            appointments.get(petName).getAppointmentDetails();
        } else {
            System.out.println("No appointment found for " + petName);
        }
    }

    public static void main(String[] args) {
        PetManager manager = new PetManager();

        // pets
        Dog dog = new Dog("Buddy", 3, "Golden Retriever", 30.0, "Owner Name 1", "Loves to slee[");
        Cat cat = new Cat("Whiskers", 2, "Siamese", 10.0, "Owner Name 2", "Loves to climb");

        manager.addPet(dog);
        manager.addPet(cat);

        //health records
        HealthRecord dogHealthRecord = new HealthRecord("2024-11-21", "Vaccinated for rabies");
        HealthRecord catHealthRecord = new HealthRecord("2024-11-22", "Vaccinated for feline distemper");

        manager.addHealthRecord(dog.getName(), dogHealthRecord);
        manager.addHealthRecord(cat.getName(), catHealthRecord);

        //feeding schedules
        FeedingSchedule dogFeedingSchedule = new FeedingSchedule("08:00 AM", "Dog Food");
        FeedingSchedule catFeedingSchedule = new FeedingSchedule("09:00 AM", "Cat Food");

        manager.addFeedingSchedule(dog.getName(), dogFeedingSchedule);
        manager.addFeedingSchedule(cat.getName(), catFeedingSchedule);

        //appointments
        Appointment dogAppointment = new Appointment("2024-12-21", "Dr. Smith");
        Appointment catAppointment = new Appointment("2024-12-22", "Dr. Brown");

        manager.addAppointment(dog.getName(), dogAppointment);
        manager.addAppointment(cat.getName(), catAppointment);

        // Retrieving details
        manager.getPetDetails("Buddy");
        manager.getHealthRecord("Buddy");
        manager.getFeedingSchedule("Buddy");
        manager.getAppointmentDetails("Buddy");

        manager.getPetDetails("Whiskers");
        manager.getHealthRecord("Whiskers");
        manager.getFeedingSchedule("Whiskers");
        manager.getAppointmentDetails("Whiskers");
    }
}


