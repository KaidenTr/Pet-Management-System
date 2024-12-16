package petmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public void saveAllInformationToFile(String filename) {
        // Get the directory of the running Java file
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir, filename);
        System.out.println("Saving to: " + file.getAbsolutePath());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Pet pet : pets) {
                String petName = pet.getName();
                writer.write("\nDetails for pet: " + petName + "\n");
                writer.write(pet.toString() + "\n");

                if (healthRecords.containsKey(petName)) {
                    writer.write("Health Record:\n");
                    writer.write(healthRecords.get(petName).toString() + "\n");
                }

                if (feedingSchedules.containsKey(petName)) {
                    writer.write("Feeding Schedule:\n");
                    writer.write(feedingSchedules.get(petName).toString() + "\n");
                }

                if (appointments.containsKey(petName)) {
                    writer.write("Appointment Details:\n");
                    writer.write(appointments.get(petName).toString() + "\n");
                }
            }
            System.out.println("Information saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while saving information to file: " + e.getMessage());
        }
    }



    public void loadPetsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String type = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String breed = parts[3];
                    double weight = Double.parseDouble(parts[4]);
                    String ownerName = parts[5];
                    String attribute = parts[6];

                    if (type.equalsIgnoreCase("Dog")) {
                        Dog dog = new Dog(name, age, breed, weight, ownerName, attribute);
                        addPet(dog);
                    } else if (type.equalsIgnoreCase("Cat")) {
                        Cat cat = new Cat(name, age, breed, weight, ownerName, attribute);
                        addPet(cat);
                    }
                }
            }
            System.out.println("Pets loaded from " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while loading pets from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        PetManager manager = new PetManager();
        manager.loadPetsFromFile("pets.txt"); // Make sure to change the file path C:/Users//eclipse-workspace/Class/src/petmanagement/pets.txt
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPet Management System");
            System.out.println("1. Add Pet");
            System.out.println("2. Add Health Record");
            System.out.println("3. Add Feeding Schedule");
            System.out.println("4. Add Appointment");
            System.out.println("5. View All Information");
            System.out.println("6. Save All Information to File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter pet type (Dog/Cat): ");
                    String type = scanner.nextLine();
                    if (!type.equalsIgnoreCase("Dog") && !type.equalsIgnoreCase("Cat")) {
                        System.out.println("Invalid pet type. Please enter 'Dog' or 'Cat'.");
                        break;
                    }
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
                    System.out.print("Enter filename to save information: ");
                    String filename = scanner.nextLine();
                    manager.saveAllInformationToFile(filename);
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


        scanner.close();
    }
}

/*
Example Input for a Dog
Enter pet type (Dog/Cat): Dog
Enter name: Buddy
Enter age: 3
Enter breed: Golden Retriever
Enter weight: 50.0
Enter owner name: John T.
Enter breed-specific attribute: Loves to fetch



Example Input for a Cat
Enter pet type (Dog/Cat): Cat
Enter name: Whiskers
Enter age: 2
Enter breed: Siamese
Enter weight: 10.0
Enter owner name: Mary Hane
Enter breed-specific attribute: Loves to climb
*/

