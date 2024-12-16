package petmanagement;

import java.util.UUID;
import java.io.Serializable;

public abstract class Pet implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures version compatibility during serialization (T.H.)

    private String petId; // Added unique identifier for each pet to avoid duplicates (T.H.)
    private String name;
    private int age;
    private String breed;
    private double weight;
    private String ownerName;

    public Pet(String name, int age, String breed, double weight, String ownerName) {
        this.petId = UUID.randomUUID().toString(); // Assign unique pet ID using UUID (T.H.)
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.ownerName = ownerName;
    }

    // Getters
    public String getPetId() {
        return petId; // Getter for unique pet ID (T.H.)
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public double getWeight() {
        return weight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // Setters
    public void setName(String name) {
        this.name = name; // Setter to allow updating pet's name (T.H.)
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age; // Added validation to ensure age is non-negative (T.H.)
        } else {
            System.out.println("Age must be zero or positive."); // Print error if age is negative (T.H.)
        }
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight; // Added validation to ensure weight is positive (T.H.)
        } else {
            System.out.println("Weight must be positive."); // Print error if weight is invalid (T.H.)
        }
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName; // Setter to allow updating owner's name (T.H.)
    }

    // Abstract Method
    public abstract void makeSound(); // Enforces specific sound behavior for each type of pet (T.H.)

    // Override toString for details
    @Override
    public String toString() {
        return "Pet ID: " + petId + "\n" +  // Added petId to provide unique identification for each pet (T.H.)
               "Name: " + name + "\n" +
               "Age: " + age + "\n" +
               "Breed: " + breed + "\n" +
               "Weight: " + weight + " kg\n" +
               "Owner: " + ownerName;
    }

    // Print details
    public void getDetails() {
        System.out.println(toString()); // Utilizes toString() to print detailed information about the pet (T.H.)
    }

    // Update all details at once
    public void updateDetails(String name, int age, String breed, double weight, String ownerName) {
        setName(name);
        setAge(age);
        setBreed(breed); // Added setter for breed to maintain consistency when updating details (T.H.)
        setWeight(weight);
        setOwnerName(ownerName);
    }

    // Setter for breed (added to make the updateDetails method more consistent) (T.H.)
    public void setBreed(String breed) {
        this.breed = breed; // Allows breed to be updated independently (T.H.)
    }
}
