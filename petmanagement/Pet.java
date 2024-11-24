package petmanagement;

public abstract class Pet {
    private String name;
    private int age;
    private String breed;
    private double weight;
    private String ownerName;

    public Pet(String name, int age, String breed, double weight, String ownerName) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.ownerName = ownerName;
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

    public abstract void makeSound();

    public void getDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Breed: " + breed);
        System.out.println("Weight: " + weight);
        System.out.println("Owner: " + ownerName);
    }

    public void updateDetails(String name, int age, String breed, double weight, String ownerName) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.ownerName = ownerName;
    }
}

