package petmanagement;

public class Cat extends Pet {
    private String breedSpecificAttribute;

    public Cat(String name, int age, String breed, double weight, String ownerName, String breedSpecificAttribute) {
        super(name, age, breed, weight, ownerName);
        this.breedSpecificAttribute = breedSpecificAttribute;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void scratch() {
        System.out.println("Scratching...");
    }
}

