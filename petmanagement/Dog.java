package petmanagement;

public class Dog extends Pet {
    private String breedSpecificAttribute;

    public Dog(String name, int age, String breed, double weight, String ownerName, String breedSpecificAttribute) {
        super(name, age, breed, weight, ownerName);
        this.breedSpecificAttribute = breedSpecificAttribute;
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }

    public void fetch() {
        System.out.println("Fetching...");
    }
}

