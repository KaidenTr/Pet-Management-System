package petmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
                return;
            }
        }
        System.out.println("No pet found with the name: " + petName);
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

    public void getAllInformation() {
        for (Pet pet : pets) {
            String petName = pet.getName();
            System.out.println("\nDetails for pet: " + petName);
            getPetDetails(petName);
            getHealthRecord(petName);
            getFeedingSchedule(petName);
            getAppointmentDetails(petName);
        }
    }

    public static void main(String[] args) {
        PetManager manager = new PetManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPet Management System");
            System.out.println("1. Add Pet");
            System.out.println("2. Add Health Record");
            System.out.println("3. Add Feeding Schedule");
            System.out.println("4. Add Appointment");
            System.out.println("5. View All Information");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter pet type (Dog/Cat): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter breed: ");
                    String breed = scanner.nextLine();
                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("Enter breed-specific attribute: ");
                    String attribute = scanner.nextLine();

                    if (type.equalsIgnoreCase("Dog")) {
                        Dog dog = new Dog(name, age, breed, weight, ownerName, attribute);
                        manager.addPet(dog);
                    } else if (type.equalsIgnoreCase("Cat")) {
                        Cat cat = new Cat(name, age, breed, weight, ownerName, attribute);
                        manager.addPet(cat);
                    } else {
                        System.out.println("Invalid pet type.");
                    }
                    break;

                case 2:
                    System.out.print("Enter pet name: ");
                    String petName = scanner.nextLine();
                    System.out.print("Enter vaccination date: ");
                    String vaccinationDate = scanner.nextLine();
                    System.out.print("Enter medical history: ");
                    String medicalHistory = scanner.nextLine();
                    System.out.print("Enter allergies: ");
                    String allergies = scanner.nextLine();

                    HealthRecord healthRecord = new HealthRecord(vaccinationDate, medicalHistory, allergies);
                    manager.addHealthRecord(petName, healthRecord);
                    break;

                case 3:
                    System.out.print("Enter pet name: ");
                    petName = scanner.nextLine();
                    System.out.print("Enter feeding time: ");
                    String feedingTime = scanner.nextLine();
                    System.out.print("Enter food type: ");
                    String foodType = scanner.nextLine();

                    FeedingSchedule feedingSchedule = new FeedingSchedule(feedingTime, foodType);
                    manager.addFeedingSchedule(petName, feedingSchedule);
                    break;

                case 4:
                    System.out.print("Enter pet name: ");
                    petName = scanner.nextLine();
                    System.out.print("Enter appointment date: ");
                    String appointmentDate = scanner.nextLine();
                    System.out.print("Enter veterinarian name: ");
                    String vetName = scanner.nextLine();

                    Appointment appointment = new Appointment(appointmentDate, vetName);
                    manager.addAppointment(petName, appointment);
                    break;

                case 5:
                    manager.getAllInformation();
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
