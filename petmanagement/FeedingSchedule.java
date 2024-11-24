package petmanagement;

public class FeedingSchedule {
    private String feedingTime;
    private String foodType;

    public FeedingSchedule(String feedingTime, String foodType) {
        this.feedingTime = feedingTime;
        this.foodType = foodType;
    }

    public void addSchedule(String feedingTime, String foodType) {
        this.feedingTime = feedingTime;
        this.foodType = foodType;
    }

    public void getSchedule() {
        System.out.println("Feeding Time: " + feedingTime);
        System.out.println("Food Type: " + foodType);
    }
}

